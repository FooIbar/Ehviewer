package com.hippo.ehviewer.ui.i10n

object ZhHkTranslations : Translations by EnTranslations {
    override val homepage = "主頁"

    override val subscription = "訂閲"

    override val whatsHot = "熱門"

    override val favourite = "收藏"

    override val history = "歷史"

    override val downloads = "下載"

    override val settings = "設置"

    override val username = "用户名"

    override val password = "密碼"

    override val signIn = "登錄"

    override val register = "註冊"

    override val signInViaWebview = "通過網頁登錄"

    override val signInFirst = "請先登錄"

    override val textIsEmpty = "文本為空"

    override val waring = "警告"

    override val invalidDownloadLocation = "似乎下載路徑不可用。請到重新設置下載路徑。"

    override val clipboardGalleryUrlSnackMessage = "剪切板裏有畫廊鏈接"

    override val clipboardGalleryUrlSnackAction = "查看"

    override val errorTimeout = "超時"

    override val errorUnknownHost = "未知主機"

    override val errorRedirection = "太多重定向"

    override val errorSocket = "網絡錯誤"

    override val errorUnknown = "奇怪的錯誤"

    override val errorCantFindActivity = "找不到相應的應用"

    override val errorCannotParseTheUrl = "無法解析鏈接"

    override val errorDecodingFailed = "解碼失敗"

    override val errorReadingFailed = "讀取失敗"

    override val errorOutOfRange = "越界"

    override val errorParseError = "解析失敗"

    override val error509 = "509"

    override val errorInvalidUrl = "無效鏈接"

    override val errorGetPtokenError = "獲取 pToken 錯誤"

    override val errorCantSaveImage = "無法保存圖片"

    override val errorInvalidNumber = "非法數字"

    override val appWaring = "本應用中內容來自互聯網，部分內容可能對您的生理及心理造成難以恢復的傷害。本應用作者不會對由本應用造成的任何後果負責。\n\n未成年人應在監護人指導下使用本應用。"

    override val errorUsernameCannotEmpty = "用户名不可為空"

    override val errorPasswordCannotEmpty = "密碼不可為空"

    override val guestMode = "跳過登錄"

    override val signInFailed = "登錄失敗"

    override val signInFailedTip = { p0: String ->
        "若持續出錯，請嘗試“%s”。"
            .format(p0)
    }

    override val getIt = "知道了"

    override val galleryListSearchBarHintExhentai = "搜索 ExHentai"

    override val galleryListSearchBarHintEHentai = "搜索 E-Hentai"

    override val galleryListSearchBarOpenGallery = "打開畫廊"

    override val galleryListEmptyHit = "什麼都沒有找到"

    override val galleryListEmptyHitSubscription = "請至 設置->EH->我的標籤 訂閲標籤"

    override val keywordSearch = "關鍵字搜索"

    override val imageSearch = "圖片搜索"

    override val searchImage = "圖片搜索"

    override val searchSh = "已刪除"

    override val searchSto = "有種子"

    override val searchSr = "最低評分"

    override val searchSpTo = "到"

    override val searchSf = "禁用排除項："

    override val searchSfl = "語言"

    override val searchSfu = "上傳者"

    override val searchSft = "標籤"

    override val selectImage = "選擇圖片"

    override val selectImageFirst = "請先選擇圖片"

    override val addToFavourites = "收藏"

    override val removeFromFavourites = "移除收藏"

    override val deleteDownloads = "刪除下載"

    override val quickSearch = "快速搜索"

    override val quickSearchTip = "點擊“+”來添加快速搜索"

    override val addQuickSearchDialogTitle = "添加快速搜索"

    override val nameIsEmpty = "名稱為空"

    override val delete = "刪除"

    override val addQuickSearchTip = "畫廊列表的狀態將被保存為快速搜索。如果你想保存搜索面板的狀態，請先執行搜索。"

    override val readme = "讀我"

    override val imageSearchNotQuickSearch = "無法添加圖片搜索為快速搜索"

    override val duplicateQuickSearch = { p0: String ->
        "已存在相同的快速搜索，名稱為“%s”。"
            .format(p0)
    }

    override val duplicateName = "已存在相同名稱"

    override val goToHint = { p0: Int, p1: Int ->
        "第 %d 頁，共 %d 頁"
            .format(p0, p1)
    }

    override val star2 = "2 星"

    override val star3 = "3 星"

    override val star4 = "4 星"

    override val star5 = "5 星"

    override val download = "下載"

    override val read = "閲讀"

    override val favoredTimes = { p0: Int ->
        "\u2665 %d"
            .format(p0)
    }

    override val ratingText = { p0: String, p1: Int ->
        "%s (%.2f, %d)"
            .format(p0, p1)
    }

    override val torrentCount = { p0: Int ->
        "種子 (%d)"
            .format(p0)
    }

    override val share = "分享"

    override val rate = "評分"

    override val similarGallery = "相似畫廊"

    override val searchCover = "搜索封面"

    override val noTags = "暫無標籤"

    override val noComments = "暫無評論"

    override val noMoreComments = "已顯示所有評論"

    override val moreComment = "查看更多評論"

    override val refresh = "刷新"

    override val openInOtherApp = "在其他應用中打開"

    override val rateSuccessfully = "評分成功"

    override val rateFailed = "評分失敗"

    override val noTorrents = "沒有種子"

    override val torrents = "種子"

    override val notFavorited = "未收藏"

    override val addFavoritesDialogTitle = "添加收藏"

    override val addToFavoriteSuccess = "已添加至收藏"

    override val removeFromFavoriteSuccess = "移除收藏"

    override val addToFavoriteFailure = "添加收藏失敗"

    override val removeFromFavoriteFailure = "移除收藏失敗"

    override val filterTheUploader = { p0: String ->
        "遮蔽上傳者“%s”？"
            .format(p0)
    }

    override val filterTheTag = { p0: String ->
        "遮蔽標籤“%s”？"
            .format(p0)
    }

    override val filterAdded = "已新增遮蔽項"

    override val rating10 = "根本把持不住"

    override val rating9 = "好極了"

    override val rating8 = "很棒"

    override val rating7 = "不錯"

    override val rating6 = "還行"

    override val rating5 = "一般般"

    override val rating4 = "不行"

    override val rating3 = "糟糕"

    override val rating2 = "瞎眼"

    override val rating1 = "快要窒息了"

    override val rating0 = "…"

    override val galleryInfo = "畫廊信息"

    override val copiedToClipboard = "已複製到剪切板"

    override val keyGid = "Gid"

    override val keyToken = "Token"

    override val keyUrl = "鏈接"

    override val keyTitle = "標題"

    override val keyTitleJpn = "日文標題"

    override val keyThumb = "縮略圖"

    override val keyCategory = "分類"

    override val keyUploader = "上傳者"

    override val keyPosted = "上傳時間"

    override val keyParent = "父畫廊"

    override val keyVisible = "可見性"

    override val keyLanguage = "語言"

    override val keyPages = "頁數"

    override val keySize = "大小"

    override val keyFavoriteCount = "收藏次數"

    override val keyFavorited = "收藏"

    override val keyRatingCount = "評價次數"

    override val keyRating = "評分"

    override val keyTorrents = "種子個數"

    override val keyTorrentUrl = "種子"

    override val galleryComments = "畫廊評論"

    override val commentSuccessfully = "評論成功"

    override val commentFailed = "評論失敗"

    override val copyCommentText = "複製評論文字"

    override val editComment = "修改評論"

    override val editCommentSuccessfully = "評論已被修改"

    override val editCommentFailed = "修改評論失敗"

    override val voteUp = "深表贊同"

    override val cancelVoteUp = "不再深表贊同"

    override val voteDown = "垃圾評論"

    override val cancelVoteDown = "不是垃圾評論"

    override val voteUpSuccessfully = "已深表贊同"

    override val cancelVoteUpSuccessfully = "已不再深表贊同"

    override val voteDownSuccessfully = "已欽定為垃圾評論"

    override val cancelVoteDownSuccessfully = "已不再欽定為垃圾評論"

    override val voteFailed = "投票失敗"

    override val checkVoteStatus = "查看投票情況"

    override val clickMoreComments = "點擊加載更多評論"

    override val lastEdited = { p0: String ->
        "上次修改時間：%s"
            .format(p0)
    }

    override val goTo = "跳頁"

    override val sceneDownloadTitle = { p0: String ->
        "下載 - %s"
            .format(p0)
    }

    override val noDownloadInfo = "這裏是下載項目"

    override val downloadStateNone = "未啟動"

    override val downloadStateWait = "等待中"

    override val downloadStateDownloading = "下載中"

    override val downloadStateDownloaded = "已下載"

    override val downloadStateFailed = "失敗"

    override val downloadStateFailed2 = { p0: Int ->
        "%d 未完成"
            .format(p0)
    }

    override val downloadStateFinish = "已完成"

    override val stat509AlertTitle = "509 警告"

    override val stat509AlertText = "圖片配額已用盡。請停止下載，休息一下。"

    override val statDownloadDoneTitle = "下載結束"

    override val statDownloadDoneTextSucceeded = { p0: Int ->
        "%d 項下載成功"
            .format(p0)
    }

    override val statDownloadDoneTextFailed = { p0: Int ->
        "%d 項下載失敗"
            .format(p0)
    }

    override val statDownloadDoneTextMix = { p0: Int, p1: Int ->
        "%d 項下載成功，%d 項下載失敗"
            .format(p0, p1)
    }

    override val statDownloadDoneLineSucceeded = { p0: String ->
        "下載成功：%s"
            .format(p0)
    }

    override val statDownloadDoneLineFailed = { p0: String ->
        "下載失敗：%s"
            .format(p0)
    }

    override val downloadRemoveDialogTitle = "移除下載項"

    override val downloadRemoveDialogMessage = { p0: String ->
        "從下載列表移除 %s ？"
            .format(p0)
    }

    override val downloadRemoveDialogMessage2 = { p0: Int ->
        "從下載列表移除 %d 項？"
            .format(p0)
    }

    override val downloadRemoveDialogCheckText = "刪除圖片文件"

    override val statDownloadActionStopAll = "全部停止"

    override val defaultDownloadLabelName = "默認"

    override val downloadMoveDialogTitle = "移動"

    override val downloadLabels = "下載標籤"

    override val downloadStartAll = "全部開始"

    override val downloadStopAll = "全部停止"

    override val downloadResetReadingProgress = "重置阅读进度"

    override val resetReadingProgressMessage = "重置所有已下载画廊的阅读进度？"

    override val downloadServiceLabel = "EhViewer 下載服務"

    override val downloadSpeedText = { p0: String ->
        "%s"
            .format(p0)
    }

    override val downloadSpeedText2 = { p0: String, p1: String ->
        "%s，剩餘 %s"
            .format(p0, p1)
    }

    override val rememberDownloadLabel = "記住下載標籤"

    override val defaultDownloadLabel = "默認下載標籤"

    override val addedToDownloadList = "已添加至下載列表"

    override val add = "添加"

    override val newLabelTitle = "新標籤"

    override val labelTextIsEmpty = "標籤文本為空"

    override val labelTextIsInvalid = "“默認”是無效標籤"

    override val labelTextExist = "標籤已存在"

    override val renameLabelTitle = "重命名標籤"

    override val noHistory = "這裏是閲讀歷史"

    override val clearAll = "全部清除"

    override val clearAllHistory = "清除所有閲讀歷史？"

    override val filter = "屏蔽畫廊"

    override val filterTitle = "標題"

    override val filterUploader = "上傳者"

    override val filterTag = "標籤"

    override val filterTagNamespace = "標籤組"

    override val deleteFilter = { p0: String ->
        "刪除屏蔽項“%s”？"
            .format(p0)
    }

    override val addFilter = "添加屏蔽項"

    override val showDefinition = "查看定義"

    override val filterText = "屏蔽項文本"

    override val filterTip = "該屏蔽系統會在 EHentai 網站屏蔽系統的基礎上繼續屏蔽畫廊。\n\n標題屏蔽項：排除標題含有該關鍵字的畫廊。\n\n上傳者屏蔽項：排除該上傳者上傳的畫廊。\n\n標籤屏蔽項：排除包含該標籤的畫廊，這會使獲取畫廊列表花費更多時間。\n\n標籤組屏蔽項：排除包含該標籤組的畫廊，這會使獲取畫廊列表花費更多時間。"

    override val uConfig = "EHentai 設置"

    override val applyTip = "點擊右上角的對勾來保存設置"

    override val myTags = "我的標籤"

    override val shareImage = "分享圖片"

    override val imageSaved = { p0: String ->
        "圖片已保存至 %s"
            .format(p0)
    }

    override val settingsEh = "EH"

    override val settingsEhSignOut = "退出登錄"

    override val settingsEhIdentityCookiesSigned = "身份 Cookie 可用於登錄該賬號。<br><b>注意數據安全</b>"

    override val settingsEhIdentityCookiesGuest = "未登錄"

    override val settingsUConfig = "EHentai 設置"

    override val settingsUConfigSummary = "EHentai 網站上的設置"

    override val settingsMyTags = "我的標籤"

    override val settingsMyTagsSummary = "EHentai 網站上的我的標籤"

    override val settingsEhGallerySite = "畫廊站點"

    override val settingsEhLaunchPage = "啟動頁"

    override val settingsEhListMode = "列表模式"

    override val settingsEhListModeDetail = "詳情"

    override val settingsEhListModeThumb = "縮略圖"

    override val settingsEhDetailSize = "詳情大小"

    override val settingsEhDetailSizeLong = "長"

    override val settingsEhDetailSizeShort = "短"

    override val settingsEhThumbColumns = "縮略圖列數"

    override val settingsEhShowJpnTitle = "顯示日文標題"

    override val settingsEhShowJpnTitleSummary = "需同時在 EHentai 網站設置中啟用 Japanese Title"

    override val settingsEhShowGalleryPages = "顯示畫廊頁數"

    override val settingsEhShowGalleryPagesSummary = "在畫廊列表中顯示頁數"

    override val settingsEhShowTagTranslations = "顯示標籤翻譯"

    override val settingsEhShowTagTranslationsSummary = "顯示翻譯後的標籤而非原始文字（需花費時間來下載數據文件）"

    override val settingsEhTagTranslationsSource = "補充翻譯（由 EhTagTranslation 提供）"

    override val settingsEhTagTranslationsSourceUrl = "https://github.com/EhTagTranslation/Editor/wiki"

    override val settingsEhFilter = "屏蔽畫廊"

    override val settingsEhFilterSummary = "根據標題、上傳者、標籤屏蔽畫廊"

    override val settingsDownload = "下載"

    override val settingsDownloadDownloadLocation = "下載路徑"

    override val settingsDownloadCantGetDownloadLocation = "無法獲取下載路徑"

    override val settingsDownloadConcurrency = "下載線程數"

    override val settingsDownloadConcurrencySummary = { p0: String ->
        "最多同時下載 %s 張圖片"
            .format(p0)
    }

    override val settingsDownloadPreloadImage = "預載圖片"

    override val settingsDownloadPreloadImageSummary = { p0: String ->
        "向後預載 %s 張圖片"
            .format(p0)
    }

    override val settingsDownloadDownloadOriginImage = "下載原圖"

    override val settingsDownloadDownloadOriginImageSummary = "這很危險！勾選此項會導致下載配額迅速流失"

    override val settingsDownloadMediaScan = "允許媒體掃描"

    override val settingsDownloadMediaScanSummaryOn = "請避免他人翻看你的圖庫應用"

    override val settingsDownloadMediaScanSummaryOff = "大多數圖庫應用將不會顯示下載目錄中的圖片"

    override val settingsDownloadRestoreDownloadItems = "恢復下載項"

    override val settingsDownloadRestoreDownloadItemsSummary = "恢復下載目錄裏的所有下載項"

    override val settingsDownloadRestoreNotFound = "未找到可恢復下載項"

    override val settingsDownloadRestoreFailed = "恢復失敗"

    override val settingsDownloadRestoreSuccessfully = { p0: Int ->
        "成功恢復 %d 項"
            .format(p0)
    }

    override val settingsDownloadCleanRedundancy = "清理下載宂餘"

    override val settingsDownloadCleanRedundancySummary = "清理下載目錄中不在下載列表裏的圖片文件"

    override val settingsDownloadCleanRedundancyNoRedundancy = "未發現宂餘"

    override val settingsDownloadCleanRedundancyDone = { p0: Int ->
        "完成宂餘清理，共清理 %d 項"
            .format(p0)
    }

    override val settingsAdvanced = "高級"

    override val settingsAdvancedSaveParseErrorBody = "解析失敗時保存頁面內容"

    override val settingsAdvancedSaveParseErrorBodySummary = "頁面內容可能含有隱私敏感信息"

    override val settingsAdvancedSaveCrashLog = "應用崩潰時保存錯誤日誌"

    override val settingsAdvancedSaveCrashLogSummary = "錯誤日誌可以幫助開發者修正問題"

    override val settingsAdvancedDumpLogcat = "導出日誌"

    override val settingsAdvancedDumpLogcatSummary = "保存日誌至外置存儲器"

    override val settingsAdvancedDumpLogcatFailed = "導出日誌失敗"

    override val settingsAdvancedDumpLogcatTo = { p0: String ->
        "已保存日誌至 %s"
            .format(p0)
    }

    override val settingsAdvancedReadCacheSize = "閲讀緩存大小"

    override val settingsAdvancedAppLanguageTitle = "App 界面語言"

    override val settingsAdvancedExportData = "導出數據"

    override val settingsAdvancedExportDataSummary = "保存數據至外置存儲器，例如下載列表，快速搜索列表"

    override val settingsAdvancedExportDataTo = { p0: String ->
        "已導出數據至 %s"
            .format(p0)
    }

    override val settingsAdvancedExportDataFailed = "導出數據失敗"

    override val settingsAdvancedImportData = "導入數據"

    override val settingsAdvancedImportDataSummary = "從外置存儲器導入數據"

    override val settingsAdvancedImportDataSuccessfully = "導入數據成功"

    override val settingsAbout = "關於"

    override val settingsAboutDeclarationSummary = "EhViewer 與 E-Hentai.org 無任何聯繫"

    override val settingsAboutAuthor = "作者"

    override val settingsAboutLatestRelease = "最新版本"

    override val settingsAboutSource = "源碼"

    override val settingsAboutVersion = "版本號"

    override val settingsAboutCheckForUpdates = "檢查更新"

    override val pleaseWait = "請稍候"

    override val cantReadTheFile = "無法讀取文件"

    override val appLanguageSystem = "系統語言（默認）"

    override val cloudFavorites = "雲端收藏"

    override val localFavorites = "本地收藏"

    override val searchBarHint = { p0: String ->
        "搜索 %s"
            .format(p0)
    }

    override val favoritesTitle = { p0: String ->
        "%s"
            .format(p0)
    }

    override val favoritesTitle2 = { p0: String, p1: String ->
        "%s - %s"
            .format(p0, p1)
    }

    override val deleteFavoritesDialogTitle = "刪除收藏"

    override val deleteFavoritesDialogMessage = { p0: Int ->
        "刪除 %d 項收藏？"
            .format(p0)
    }

    override val moveFavoritesDialogTitle = "移動收藏"

    override val defaultFavoritesCollection = "默認收藏夾"

    override val letMeSelect = "讓我選擇"

    override val collections = "收藏夾"

    override val errorSomethingWrongHappened = "被玩壞了"

    override val fromTheFuture = "來自未來"

    override val justNow = "剛剛"

    override val yesterday = "昨天"

    override val someDaysAgo = { p0: Int ->
        "%d 天前"
            .format(p0)
    }

    override val archive = "壓縮包"

    override val noArchives = "沒有壓縮包"

    override val downloadArchiveStarted = "開始下載壓縮包"

    override val downloadArchiveFailure = "無法下載壓縮包"

    override val downloadArchiveFailureNoHath = "下載壓縮包需要 H@H 客户端"

    override val settingsPrivacy = "隱私"

    override val settingsPrivacySecure = "不允許荧幕抓取"

    override val settingsPrivacySecureSummary = "啟用後，將不能截取該應用的螢幕截圖，同時，將不會在系統任務切換器中顯示該應用的內容預覽，重新啟動應用以生效此更改"

    override val favoriteName = "收藏畫廊"

    override val actionSettings = "設定"

    override val actionRetry = "重試"

    override val actionShare = "分享"

    override val actionSave = "儲存"

    override val actionSaveTo = "儲存到…"

    override val prefCategoryGeneral = "一般"

    override val prefFullscreen = "全螢幕"

    override val prefShowPageNumber = "顯示頁碼"

    override val prefCustomBrightness = "自訂亮度"

    override val prefCustomColorFilter = "色彩濾鏡"

    override val prefKeepScreenOn = "保持螢幕恆亮"

    override val prefRotationType = "預設螢幕方向"

    override val rotationFree = "自動"

    override val rotationForcePortrait = "鎖定直向"

    override val rotationForceLandscape = "鎖定橫向"

    override val prefPageTransitions = "翻頁轉場動畫"

    override val prefColorFilterMode = "濾鏡融合機制"

    override val filterModeMultiply = "色彩增值"

    override val filterModeScreen = "濾色"

    override val filterModeOverlay = "覆蓋"

    override val filterModeLighten = "減淡/變亮"

    override val filterModeDarken = "加深/變暗"

    override val prefReadWithLongTap = "長按顯示"

    override val prefReaderTheme = "背景顏色"

    override val whiteBackground = "白色"

    override val blackBackground = "黑色"

    override val leftToRightViewer = "由左至右"

    override val rightToLeftViewer = "由右至左"

    override val verticalViewer = "由上至下"

    override val webtoonViewer = "Webtoon 模式"

    override val pagerViewer = "單頁式"

    override val prefImageScaleType = "縮放模式"

    override val scaleTypeFitScreen = "符合螢幕"

    override val scaleTypeStretch = "延展"

    override val scaleTypeFitWidth = "符合頁寬"

    override val scaleTypeFitHeight = "符合頁高"

    override val scaleTypeOriginalSize = "原始大小"

    override val scaleTypeSmartFit = "智慧型填充"

    override val prefZoomStart = "縮放原點"

    override val zoomStartAutomatic = "自動"

    override val zoomStartLeft = "左邊"

    override val zoomStartRight = "右邊"

    override val zoomStartCenter = "中間"

    override val decodeImageError = "無法載入該圖片"

    override val downloadAll = "全部"

    override val customFilter = "濾鏡"

    override val grayBackground = "灰色"

    override val webtoonSidePadding25 = "25%"

    override val webtoonSidePadding20 = "20%"

    override val webtoonSidePadding15 = "15%"

    override val webtoonSidePadding10 = "10%"

    override val webtoonSidePadding0 = "無"

    override val actionMenu = "選單"

    override val prefCutoutShort = "使用螢幕凹口區域"

    override val prefWebtoonSidePadding = "頁緣留白"

    override val viewer = "閱讀模式"

    override val tappingInvertedBoth = "全部"

    override val tappingInvertedVertical = "垂直"

    override val tappingInvertedHorizontal = "水平"

    override val prefReadWithTappingInverted = "反轉輕觸區域"

    override val verticalPlusViewer = "垂直連貫"

    override val tappingInvertedNone = "無"

    override val prefCategoryReadingMode = "閱讀模式"

    override val edgeNav = "邊緣式"

    override val kindlishNav = "Kindle 式"

    override val lNav = "L 式"

    override val prefViewerNav = "輕觸區域"

    override val rightAndLeftNav = "左右式"

    override val rotationPortrait = "直向"

    override val rotationType = "螢幕方向"

    override val navZoneLeft = "左邊"

    override val navZonePrev = "上一頁"

    override val navZoneNext = "下一頁"

    override val navZoneRight = "右邊"

    override val rotationLandscape = "橫向"

    override val automaticBackground = "自動"

    override val prefGrayscale = "灰階"

    override val prefInvertedColors = "反轉"

    override val labelDefault = "預設"

    override val webtoonSidePadding5 = "5%"

    override val prefLandscapeZoom = "縮放橫向圖片"

    override val prefNavigatePan = "輕觸時移動圖片"

    override val rotationReversePortrait = "顛倒直向"

    override val disabledNav = "停用"

    override val pageCount = { quantity: Int ->
        when (quantity) {
            else -> "%d 頁"
        }.format(quantity)
    }

    override val someMinutesAgo = { quantity: Int ->
        when (quantity) {
            else -> "%d 分鐘前"
        }.format(quantity)
    }

    override val someHoursAgo = { quantity: Int ->
        when (quantity) {
            else -> "%d 小時前"
        }.format(quantity)
    }

    override val second = { quantity: Int ->
        when (quantity) {
            else -> "秒"
        }.format(quantity)
    }

    override val minute = { quantity: Int ->
        when (quantity) {
            else -> "分鐘"
        }.format(quantity)
    }

    override val hour = { quantity: Int ->
        when (quantity) {
            else -> "小時"
        }.format(quantity)
    }

    override val day = { quantity: Int ->
        when (quantity) {
            else -> "天"
        }.format(quantity)
    }

    override val year = { quantity: Int ->
        when (quantity) {
            else -> "年"
        }.format(quantity)
    }
}
