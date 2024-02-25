package com.example.socialproblemandroid.data.model.remote.response

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "response")
data class NewsResponse(
    @PropertyElement (name="script")
    val script: String?,
    @Element (name="header")
    val header: NewsHeader,
    @Element (name="body")
    val body: NewsBody
)

@Xml(name = "header")
data class NewsHeader(
    @PropertyElement (name="resultCode")
    val resultCode: String,
    @PropertyElement (name="resultMsg")
    val resultMsg: String
)

@Xml(name = "body")
data class NewsBody(
    @Element(name="NewsItem")
    val newsItems: List<NewsItem>
)

@Xml(name = "NewsItem")
data class NewsItem(
    @PropertyElement(name="NewsItemId")
    val newsItemId: String?,

    @PropertyElement(name="ContentsStatus")
    val contentsStatus: String?,

    @PropertyElement(name="ModifyId")
    val modifyId: String?,

    @PropertyElement(name = "ModifyDate")
    val modifyDate: String?,

    @PropertyElement(name = "ApproveDate")
    val approveDate: String?,

    @PropertyElement(name = "ApproverName")
    val approverName: String?,

    @PropertyElement(name = "EmbargoDate")
    val embargoDate: String?,

    @PropertyElement(name = "GroupingCode")
    val groupingCode: String?,

    @PropertyElement(name = "Title")
    val title: String?,

    @PropertyElement(name = "SubTitle1")
    val subTitle1: String?,

    @PropertyElement(name = "SubTitle2")
    val subTitle2: String?,

    @PropertyElement(name = "SubTitle3")
    val subTitle3: String?,

    @PropertyElement(name = "ContentsType")
    val contentsType: String?,

    @PropertyElement(name = "DataContents")
    val dataContents: String?,

    @PropertyElement(name = "MinisterCode")
    val ministerCode: String?,

    @PropertyElement(name = "OriginalUrl")
    val originalUrl: String?,

    @PropertyElement(name = "ThumbnailUrl")
    val thumbnailUrl: String?,

    @PropertyElement(name = "OriginalimgUrl")
    val originalImgUrl: String?
)