package com.example.socialproblemandroid.presentation.type

import com.example.socialproblemandroid.R

enum class NewsCategoryType(val keywords: List<String>, val tag: String, val iconRes: Int) {
    ECONOMY(listOf("기획재정부", "농림축산식품부", "산업통상자원부", "해양수산부", "중소벤처기업부"), "#경제 #돈 #관세 #수입 #수출", R.drawable.img_money),
    LABOR(listOf("고용노동부"), "#노동 #고용", R.drawable.img_labor),
    WELFARE(listOf("보건복지부", "여성가족부", "방송통신위원회", "행정안전부", "소방청"), "#의료 #복지", R.drawable.img_welfare),
    SOCIETY(listOf("환경부", "행정자치부", "외교부", "문화체육관광부", "교육부", "통일부"), "#사회 #외교", R.drawable.img_society),
    UNKNOWN(emptyList(), "", R.drawable.img_white)
}