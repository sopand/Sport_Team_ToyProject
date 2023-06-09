package com.study.controller;

import com.study.dto.ClubRequest;
import com.study.dto.ClubResponse;
import com.study.exception.CustomException;
import com.study.exception.ErrorCode;
import com.study.oAuth.UserAdapter;
import com.study.service.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class ClubController {

    private final ClubService clubService;

    public static Long getUserNo(UserAdapter userAdapter){
        if(userAdapter!=null){
            return userAdapter.getUser().getNo();
        }else{
            throw new CustomException(ErrorCode.FORBIDDEN_ACCESS);
        }
    }
    @ResponseBody
    @PostMapping("/boards/club")
    public ClubResponse createClub(@AuthenticationPrincipal UserAdapter userAdapter, ClubRequest clubRequest){
        return clubService.createClubUser(clubRequest);
    }

}
