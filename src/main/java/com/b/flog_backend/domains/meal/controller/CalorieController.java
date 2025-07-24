package com.b.flog_backend.domains.meal.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.text.SimpleDateFormat;
// import java.util.Date;
// import java.util.UUID;
// import org.springframework.web.multipart.MultipartFile;

import com.b.flog_backend.domains.meal.dto.FoodDto;
import com.b.flog_backend.domains.meal.dto.GoalCalorieDto;
import com.b.flog_backend.domains.meal.dto.TodayCalorieDto;
import com.b.flog_backend.domains.meal.response.TotalCalorie;
import com.b.flog_backend.domains.meal.service.CalorieService;
// import com.google.api.client.http.MultipartContent.Part;
// import com.google.api.client.util.Data;
// import com.google.genai.Client;
// import com.google.genai.types.GenerateContentResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meal/calorie")
public class CalorieController {
    
    @Autowired
    private CalorieService calorieService;

    @Autowired
    @Qualifier("fileRootPath")
    private String rootPath;

    private int getUserId() {
        return (int)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @PostMapping("/insertTodayCalorie")
    public TodayCalorieDto insertCalorie() {

        int userId = getUserId();

        TodayCalorieDto calorie = calorieService.findTodayCalorieByUserIdAndDate(userId, LocalDate.now());
        if (calorie != null) {
            return calorie; // 이미 오늘의 칼로리 정보가 존재하는 경우
        }

        calorieService.insertTodayCalorie(userId);

        return calorieService.findTodayCalorieByUserIdAndDate(userId, LocalDate.now());
    }

    @GetMapping("/findTodayCalorieListByUserId")
    public List<TodayCalorieDto> findTodayCalorieListByUserId(@RequestParam("userId") int userId) {
        return calorieService.findTodayCalorieListByUserId(userId);
    }

    @GetMapping("/findTotalCalorieByTodayCalorie")
    public List<TotalCalorie> findTotalCalorieByTodayCalorie(@RequestParam("todayCalorieId") int todayCalorieId) {
        return calorieService.findTotalCalorieByTodayCalorieId(todayCalorieId);
    }

    @GetMapping("/findTodayTotalCalorie")
    public List<TotalCalorie> findTodayCalorieByUserId() {
        int userId = getUserId();

        TodayCalorieDto todayCalorieDto = calorieService.findTodayCalorieByUserId(userId);
        if (todayCalorieDto == null) {
            insertCalorie();
            todayCalorieDto = calorieService.findTodayCalorieByUserId(userId);
        }

        return calorieService.findTotalCalorieByTodayCalorieId(todayCalorieDto.getId());
    }

    @PostMapping("/insertFood")
    public void insertFood(@RequestBody FoodDto foodDto) {
        calorieService.insertFood(foodDto);
    }

    // @PostMapping("/insertFood")
    // public FoodDto insertFood(@RequestParam("image") MultipartFile image) throws IOException {
    //     FoodDto foodDto = new FoodDto();
    //     // image 폴더에 저장 -> 주소 저장

    //     if (image != null && !image.isEmpty()) {
    //         String uploadRootPath = rootPath + "meal/food/";

    //         String originalFilename = image.getOriginalFilename();
                
    //         // 확장자 유효성 검사
    //         if (originalFilename == null ||
    //             !(originalFilename.toLowerCase().endsWith(".jpg") ||
    //             originalFilename.toLowerCase().endsWith(".jpeg") ||
    //             originalFilename.toLowerCase().endsWith(".png"))) {
    //             return foodDto;
    //         }

    //         // 안전한 파일명 생성
    //         String uuid = UUID.randomUUID().toString();
    //         long timestamp = System.currentTimeMillis();
    //         String filename = uuid + "_" + timestamp + "." + originalFilename.substring(originalFilename.lastIndexOf('.') + 1);

    //         // 날짜별 경로 생성
    //         String todayPath = new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
    //         Path uploadDirPath = Paths.get(uploadRootPath, todayPath);

    //         if (!Files.exists(uploadDirPath)) {
    //             Files.createDirectories(uploadDirPath);
    //         }

    //         // 최종 저장 경로
    //         Path filePath = uploadDirPath.resolve(filename);
    //         image.transferTo(filePath.toFile());

    //         // 상대 경로 저장
    //         foodDto.setImageAddress("meal/food/" + todayPath + filename);
    //     }

    //     // // gemini API 호출 -> 칼로리 정보 저장
    //     // Client client = new Client();

    //     // byte[] imageBytes = Files.readAllBytes(Path.of("path/to/image.jpg"));

    //     // // 이미지 파트 생성 (MIME 타입 필수)
    //     // Part imagePart = Part.of(Data.of("image/jpeg", imageBytes));

    //     // // 텍스트 파트 생성
    //     // Part textPart = Part.of("이 이미지에 있는 음식이 무엇이고, 칼로리는 대략 얼마인지 알려줘. 답변은 '음식 이름: [이름], 칼로리: [숫자]kcal' 형식으로 구조화해서 줘. 여러 개면 목록으로 나열해줘. 음식이 감지되지 않으면 '음식을 감지할 수 없습니다.'라고 답변해줘."));

    //     // // Content 객체에 이미지 + 텍스트 파트 넣기
    //     // Content content = Content.of(List.of(imagePart, textPart));

    //     // String response = client.models.generateContent(
    //     //     "gemini-2.5-flash",
    //     //     ([image, "Tell me about this instrument"]),
    //     //     null
    //     // )

    //     // foodDto에 필요한 정보 설정
    //     calorieService.insertFood(foodDto);
    //     return foodDto;
    // }

    @PostMapping("insertGoalCalorie")
    public void insertGoalCalorie(@RequestBody GoalCalorieDto goalCalorieDto) {
        int userId = getUserId();
        Integer goalCalorie = calorieService.selectGoalCalorieByUserId(userId);
        goalCalorieDto.setUserId(userId);
        if (goalCalorie == null) {
            calorieService.insertGoalCalorie(goalCalorieDto);
        } else {
            calorieService.updateGoalCalorie(goalCalorieDto);
        }
    }

    @GetMapping("findGoalCalorie")
    public Integer findGoalCalorie() {
        return calorieService.selectGoalCalorieByUserId(getUserId());
    }

    @GetMapping("findFoodListByMealId")
    public List<FoodDto> findFoodListByMealId(@RequestParam("mealId") int mealId) {
        return calorieService.findFoodListByMealId(mealId);
    }
    
    @PutMapping("updateFood")
    public void updateFood(@RequestBody FoodDto foodDto) {
        calorieService.updateFood(foodDto);
    }

    @DeleteMapping("deleteFood")
    public void deleteFood(@RequestParam("id") int id) {
        calorieService.deleteFood(id);
    }

    @GetMapping("findCalorie")
    public List<Map<String, Object>> findCalorie() {
        return calorieService.findCalorie(getUserId());
    }
}
