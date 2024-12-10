package com.hippo.ehviewer.ui.i18n

object ZhTwTranslations : Translations by EnTranslations {
    override val homepage = "首頁"
    override val subscription = "訂閱"
    override val whatsHot = "熱門"
    override val favourite = "收藏"
    override val history = "歷史"
    override val downloads = "下載"
    override val settings = "設定"
    override val username = "使用者名稱"
    override val password = "密碼"
    override val signIn = "登入"
    override val register = "註冊"
    override val signInViaWebview = "透過網頁登入"
    override val signInFirst = "請先登入"
    override val textIsEmpty = "文字是空的"
    override val waring = "警告"
    override val invalidDownloadLocation = "看來下載路徑似乎沒辦法使用。請至設定重新設定下載路徑。"
    override val clipboardGalleryUrlSnackMessage = "剪貼簿裡有圖庫連結"
    override val clipboardGalleryUrlSnackAction = "檢視"
    override val errorTimeout = "逾時"
    override val errorUnknownHost = "未知的主機"
    override val errorRedirection = "重新導向迴圈"
    override val errorSocket = "網路錯誤"
    override val errorUnknown = "奇怪的錯誤"
    override val errorCantFindActivity = "找不到相對應的應用程式"
    override val errorCannotParseTheUrl = "無法解析連結"
    override val errorDecodingFailed = "解碼失敗"
    override val errorReadingFailed = "讀取失敗"
    override val errorOutOfRange = "超出範圍"
    override val errorParseError = "解析失敗"
    override val error509 = "509"
    override val errorInvalidUrl = "不正確的連結"
    override val errorGetPtokenError = "取得 pToken 時發生錯誤"
    override val errorCantSaveImage = "無法儲存圖片"
    override val errorInvalidNumber = "無效的數字"
    override val appWaring =
        "本應用程式中內容來自網際網路，部分內容可能對您的生理及心理造成難以恢復的傷害。本應用程式的作者不會對由其所造成的任何影響負責。\n\n未成年人應在監護人指導下使用本應用程式。\n\n繼續使用即代表您同意上述條款。"
    override val appWaring2 = "繼續使用即表示您同意上述條款。"
    override val errorUsernameCannotEmpty = "使用者名稱欄位不能為空"
    override val errorPasswordCannotEmpty = "密碼欄位不能為空"
    override val guestMode = "略過登入"
    override val signInFailed = "登入失敗"
    override val signInFailedTip = { p0: String ->
        "若持續出錯，請嘗試“%s”。"
            .format(p0)
    }
    override val getIt = "知道了"
    override val galleryListSearchBarHintExhentai = "在 ExHentai 搜尋"
    override val galleryListSearchBarHintEHentai = "在 E-Hentai 搜尋"
    override val galleryListSearchBarOpenGallery = "開啟圖庫"
    override val galleryListEmptyHit = "什麼都沒找到"
    override val galleryListEmptyHitSubscription = "請至 設定->EH->我的標籤 訂閱標籤"
    override val keywordSearch = "關鍵字搜尋"
    override val imageSearch = "圖片搜尋"
    override val searchImage = "圖片搜尋"
    override val searchSh = "已被移除"
    override val searchSto = "有種子"
    override val searchSr = "最低評分"
    override val searchSpTo = "到"
    override val searchSpErr1 = "頁數最大值至少為 10"
    override val searchSpErr2 = "頁數範圍差至少為 20"
    override val searchSf = "停用排除項："
    override val searchSfl = "語言"
    override val searchSfu = "上傳者"
    override val searchSft = "標籤"
    override val selectImage = "選擇圖片"
    override val selectImageFirst = "請先選擇圖片"
    override val addToFavourites = "收藏"
    override val removeFromFavourites = "移除收藏"
    override val deleteDownloads = "刪除下載"
    override val quickSearch = "快速搜尋"
    override val quickSearchTip = "點選“+”以新增快速搜尋"
    override val addQuickSearchDialogTitle = "新增快速搜尋"
    override val nameIsEmpty = "名稱是空的"
    override val delete = "刪除"
    override val addQuickSearchTip =
        "圖庫列表的狀態將被儲存為快速搜尋。如果你想儲存搜尋面板的狀態，請先進行搜尋。"
    override val readme = "ReadMe"
    override val imageSearchNotQuickSearch = "無法將圖片搜尋加入快速搜尋"
    override val duplicateQuickSearch = { p0: String ->
        "已存在相同的快速搜尋，名稱為“%s”。"
            .format(p0)
    }
    override val duplicateName = "名稱重複"
    override val saveProgress = "儲存進度"
    override val deleteQuickSearch = { p0: String ->
        "刪除快速搜尋“%s”？"
            .format(p0)
    }
    override val goToHint = { p0: Int, p1: Int ->
        "第 %d 頁，共 %d 頁"
            .format(p0, p1)
    }
    override val any = "不限"
    override val star2 = "2 星"
    override val star3 = "3 星"
    override val star4 = "4 星"
    override val star5 = "5 星"
    override val download = "下載"
    override val read = "閱讀"
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
    override val similarGallery = "類似圖庫"
    override val searchCover = "以封面搜尋"
    override val noTags = "還沒有標籤"
    override val noComments = "沒有留言"
    override val noMoreComments = "已顯示所有的留言了"
    override val moreComment = "更多留言"
    override val refresh = "重新整理"
    override val viewOriginal = "查看原圖"
    override val openInOtherApp = "在其他應用程式中開啟"
    override val clearImageCache = "清除圖片快取"
    override val clearImageCacheConfirm = "為該圖庫清除所有快取圖片？"
    override val imageCacheCleared = "已清除圖片快取"
    override val rateSuccessfully = "評分成功"
    override val rateFailed = "評分失敗"
    override val noTorrents = "沒有種子"
    override val torrents = "種子"
    override val notFavorited = "未收藏"
    override val addFavoritesDialogTitle = "新增到收藏裡"
    override val addToFavoriteSuccess = "已新增至收藏中"
    override val removeFromFavoriteSuccess = "從收藏中移除"
    override val addToFavoriteFailure = "無法新增至收藏"
    override val removeFromFavoriteFailure = "無法從收藏中移除"
    override val filterTheUploader = { p0: String ->
        "把上傳者“%s”加入過濾列表？"
            .format(p0)
    }
    override val filterTheTag = { p0: String ->
        "隱藏標籤“%s”？"
            .format(p0)
    }
    override val filterAdded = "已經新增篩選條件"
    override val newerVersionAvailable = "此圖庫有新版本可以使用。"
    override val newerVersionTitle = { p0: String, p1: String ->
        "%s, 於 %s 加入"
            .format(p0, p1)
    }
    override val rating10 = "太神啦！"
    override val rating9 = "根本把持不住"
    override val rating8 = "很棒"
    override val rating7 = "不錯"
    override val rating6 = "還好"
    override val rating5 = "普通"
    override val rating4 = "不行"
    override val rating3 = "超爛"
    override val rating2 = "快瞎了"
    override val rating1 = "快要窒息了"
    override val rating0 = "下去！"
    override val galleryInfo = "圖庫資訊"
    override val copiedToClipboard = "已複製到剪貼簿"
    override val keyGid = "GID"
    override val keyToken = "Token"
    override val keyUrl = "網址"
    override val keyTitle = "標題"
    override val keyTitleJpn = "日文標題"
    override val keyThumb = "縮圖"
    override val keyCategory = "分類"
    override val keyUploader = "上傳者"
    override val keyPosted = "上傳時間"
    override val keyParent = "上層圖庫"
    override val keyVisible = "可見"
    override val keyLanguage = "語言"
    override val keyPages = "頁數"
    override val keySize = "大小"
    override val keyFavoriteCount = "收藏次數"
    override val keyFavorited = "收藏"
    override val keyRatingCount = "評分次數"
    override val keyRating = "分數"
    override val keyTorrents = "種子數"
    override val keyTorrentUrl = "種子連結"
    override val galleryComments = "圖庫留言"
    override val commentSuccessfully = "留言成功"
    override val commentFailed = "留言失敗"
    override val copyCommentText = "複製留言文字"
    override val blockCommenter = "隱藏評論者"
    override val filterTheCommenter = { p0: String ->
        "隱藏評論者“%s”？"
            .format(p0)
    }
    override val editComment = "修改留言"
    override val editCommentSuccessfully = "留言已被修改"
    override val editCommentFailed = "修改留言失敗"
    override val voteUp = "推"
    override val cancelVoteUp = "收回推"
    override val voteDown = "噓"
    override val cancelVoteDown = "收回噓"
    override val voteUpSuccessfully = "發出推了"
    override val cancelVoteUpSuccessfully = "已經收回推了"
    override val voteDownSuccessfully = "發出噓了"
    override val cancelVoteDownSuccessfully = "已經收回噓了"
    override val voteFailed = "推噓失敗"
    override val checkVoteStatus = "檢視推噓狀態"
    override val clickMoreComments = "點選載入更多留言"
    override val lastEdited = { p0: String ->
        "上次修改時間：%s"
            .format(p0)
    }
    override val formatBold = "粗體"
    override val formatItalic = "斜體"
    override val formatUnderline = "底線"
    override val formatStrikethrough = "刪除線"
    override val formatUrl = "連結"
    override val formatPlain = "純文字"
    override val goTo = "跳到"
    override val sceneDownloadTitle = { p0: String ->
        "正在下載 - %s"
            .format(p0)
    }
    override val noDownloadInfo = "下載項目將顯示在此"
    override val downloadStateNone = "閒置中"
    override val downloadStateWait = "等待中"
    override val downloadStateDownloading = "下載中"
    override val downloadStateDownloaded = "已下載"
    override val downloadStateFailed = "下載失敗"
    override val downloadStateFailed2 = { p0: Int ->
        "還有 %d 未完成"
            .format(p0)
    }
    override val downloadStateFinish = "大功告成"
    override val stat509AlertTitle = "509 警告"
    override val stat509AlertText = "圖片流量已用盡。請停止下載，休息一下。"
    override val statDownloadDoneTitle = "下載結束"
    override val statDownloadDoneTextSucceeded = { p0: Int ->
        "有 %d 項已成功下載"
            .format(p0)
    }
    override val statDownloadDoneTextFailed = { p0: Int ->
        "有 %d 項下載失敗"
            .format(p0)
    }
    override val statDownloadDoneTextMix = { p0: Int, p1: Int ->
        "%d 項成功下載，%d 項下載失敗"
            .format(p0, p1)
    }
    override val statDownloadDoneLineSucceeded = { p0: String ->
        "%s 下載成功"
            .format(p0)
    }
    override val statDownloadDoneLineFailed = { p0: String ->
        "%s 下載失敗"
            .format(p0)
    }
    override val downloadRemoveDialogTitle = "移除下載佇列"
    override val downloadRemoveDialogMessage = { p0: String ->
        "將 %s 從下載佇列中移除嗎？"
            .format(p0)
    }
    override val downloadRemoveDialogMessage2 = { p0: Int ->
        "從下載佇列中移除 %d 項任務嗎？"
            .format(p0)
    }
    override val downloadRemoveDialogCheckText = "刪除圖檔"
    override val statDownloadActionStopAll = "全部停止"
    override val defaultDownloadLabelName = "預設"
    override val downloadMoveDialogTitle = "移動"
    override val downloadLabels = "下載標籤"
    override val downloadStartAll = "全部開始"
    override val downloadStopAll = "全部停止"
    override val downloadResetReadingProgress = "重置閱讀進度"
    override val resetReadingProgressMessage = "重置所有已下載圖庫的閱讀進度？"
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
    override val defaultDownloadLabel = "預設下載標籤"
    override val addedToDownloadList = "已新增至下載列表"
    override val selectGroupingMode = "選擇分組依據"
    override val selectGroupingModeCustom = "自定義標籤"
    override val selectGroupingModeArtist = "作者"
    override val unknownArtists = "未知"
    override val add = "新增"
    override val newLabelTitle = "新標籤"
    override val labelTextIsEmpty = "標籤文字是空的"
    override val labelTextIsInvalid = "“預設”是無效的標籤"
    override val labelTextExist = "標籤已存在"
    override val renameLabelTitle = "重新命名標籤"
    override val deleteLabel = { p0: String ->
        "刪除標籤“%s”？"
            .format(p0)
    }
    override val noHistory = "歷史紀錄將會顯示在這裡"
    override val clearAll = "全部清除"
    override val clearAllHistory = "清除所有歷史紀錄？"
    override val filter = "隱藏圖庫"
    override val filterTitle = "標題"
    override val filterUploader = "上傳者"
    override val filterTag = "標籤"
    override val filterTagNamespace = "標籤組"
    override val filterCommenter = "評論者"
    override val filterComment = "評論"
    override val deleteFilter = { p0: String ->
        "刪除隱藏項“%s”？"
            .format(p0)
    }
    override val addFilter = "新增隱藏項"
    override val showDefinition = "檢視定義"
    override val filterText = "隱藏項文字"
    override val filterTip =
        "該隱藏系統會在 EHentai 網站隱藏系統的基礎上繼續隱藏圖庫。\n\n標題隱藏項：排除標題含有該關鍵字的圖庫。\n\n上傳者隱藏項：排除該上傳者上傳的圖庫。\n\n標籤隱藏項：排除包含該標籤的圖庫，這會使獲取圖庫列表花費更多時間。\n\n標籤組隱藏項：排除包含該標籤組的圖庫，這會使獲取圖庫列表花費更多時間。"
    override val uConfig = "EHentai 設定"
    override val applyTip = "點選右上角的勾勾以儲存設定"
    override val myTags = "我的標籤"
    override val shareImage = "分享圖片"
    override val imageSaved = { p0: String ->
        "已將圖片儲存至 %s"
            .format(p0)
    }
    override val settingsEh = "EH"
    override val settingsEhSignOut = "登出"
    override val settingsEhIdentityCookiesSigned =
        "身份 Cookie 可用於登入該帳號。<br><b>請注意資料安全</b>"
    override val settingsEhIdentityCookiesGuest = "訪客模式"
    override val settingsEhClearIgneous = "清除 igneous"
    override val settingsUConfig = "EHentai 設定"
    override val settingsUConfigSummary = "EHentai 網站上的設定"
    override val settingsMyTags = "我的標籤"
    override val settingsMyTagsSummary = "EHentai 網站上的我的標籤"
    override val settingsEhGallerySite = "圖庫站臺"
    override val settingsEhLaunchPage = "啟動頁"
    override val settingsEhListMode = "列表模式"
    override val settingsEhListModeDetail = "詳細資料"
    override val settingsEhListModeThumb = "縮圖"
    override val settingsEhDetailSize = "詳細大小"
    override val settingsEhDetailSizeLong = "長"
    override val settingsEhDetailSizeShort = "短"
    override val settingsEhThumbColumns = "縮圖列數"
    override val settingsEhForceEhThumb = "使用 e-hentai 縮圖伺服器"
    override val settingsEhForceEhThumbSummary = "若縮圖載入遇到問題可嘗試停用此項"
    override val settingsEhShowJpnTitle = "顯示日文標題"
    override val settingsEhShowJpnTitleSummary = "需同時在 EHentai 網站設定中啟用 Japanese Title"
    override val settingsEhShowGalleryPages = "顯示圖庫頁數"
    override val settingsEhShowGalleryPagesSummary = "在圖庫列表中顯示頁數"
    override val settingsEhShowGalleryComments = "顯示圖庫評論"
    override val settingsEhShowGalleryCommentsSummary = "在圖庫詳情頁中顯示評論"
    override val settingsEhShowGalleryCommentThreshold = "評論分數閥值"
    override val settingsEhShowGalleryCommentThresholdSummary =
        "隱藏小於或等於設定分數的評論（-101 為停用）"
    override val settingsEhShowTagTranslations = "顯示標籤翻譯"
    override val settingsEhShowTagTranslationsSummary =
        "顯示翻譯後的標籤而非原始文字（需花費時間來下載資料檔案）"
    override val settingsEhTagTranslationsSource = "補充翻譯（由 EhTagTranslation 提供）"
    override val settingsEhTagTranslationsSourceUrl =
        "https://github.com/EhTagTranslation/Editor/wiki"
    override val settingsEhFilter = "隱藏圖庫"
    override val settingsEhFilterSummary = "根據標題、上傳者、標籤、評論者隱藏圖庫或評論"
    override val settingsDownload = "下載"
    override val settingsDownloadDownloadLocation = "下載路徑"
    override val settingsDownloadCantGetDownloadLocation = "無法取得下載路徑"
    override val settingsDownloadConcurrency = "並行下載數"
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
    override val settingsDownloadDownloadOriginImageSummary =
        "這很危險！勾選這個選項會導致圖片流量配額快速耗用"
    override val settingsDownloadSaveAsCbz = "儲存為 CBZ 壓縮檔"
    override val settingsDownloadArchiveMetadata = "壓縮檔中繼資料"
    override val settingsDownloadArchiveMetadataSummary = "下載壓縮檔時產生 ComicInfo.xml"
    override val settingsDownloadReloadMetadata = "重新載入中繼資料"
    override val settingsDownloadReloadMetadataSummary =
        "為標籤可能發生變動的下載項更新 ComicInfo.xml"
    override val settingsDownloadReloadMetadataSuccessfully = { p0: Int ->
        "成功載入 %d 項"
            .format(p0)
    }
    override val settingsDownloadReloadMetadataFailed = { p0: String ->
        "載入中繼資料失敗: %s"
            .format(p0)
    }
    override val settingsDownloadMediaScan = "允許其他程式進行媒體掃描"
    override val settingsDownloadMediaScanSummaryOn = "請別讓別人看到你的相簿"
    override val settingsDownloadMediaScanSummaryOff = "大部分相簿軟體將會忽略顯示下載路徑中的影像"
    override val settingsDownloadRestoreDownloadItems = "復原下載的檔案"
    override val settingsDownloadRestoreDownloadItemsSummary = "復原下載路徑中的所有下載的檔案"
    override val settingsDownloadRestoreNotFound = "未尋獲可復原的已下載檔案"
    override val settingsDownloadRestoreFailed = "復原失敗"
    override val settingsDownloadRestoreSuccessfully = { p0: Int ->
        "成功復原 %d 項"
            .format(p0)
    }
    override val settingsDownloadCleanRedundancy = "清除冗餘的檔案"
    override val settingsDownloadCleanRedundancySummary = "清除已下載但不在下載列表中的圖檔"
    override val settingsDownloadCleanRedundancyNoRedundancy = "未發現冗餘檔案"
    override val settingsDownloadCleanRedundancyDone = { p0: Int ->
        "完成冗餘檔案清理，共清理了 %d 個檔案"
            .format(p0)
    }
    override val settingsAdvanced = "進階"
    override val settingsAdvancedSaveParseErrorBody = "解析失敗時儲存網頁的內容"
    override val settingsAdvancedSaveParseErrorBodySummary = "網頁內容可能含有敏感的隱私資料"
    override val settingsAdvancedSaveCrashLog = "應用程式崩潰時儲存錯誤日誌"
    override val settingsAdvancedSaveCrashLogSummary = "錯誤日誌可以幫助開發者修正問題"
    override val settingsAdvancedDumpLogcat = "傾印記錄檔"
    override val settingsAdvancedDumpLogcatSummary = "將紀錄檔儲存至外接儲存裝置"
    override val settingsAdvancedDumpLogcatFailed = "無法傾印紀錄檔"
    override val settingsAdvancedDumpLogcatTo = { p0: String ->
        "已將紀錄檔儲存至 %s"
            .format(p0)
    }
    override val settingsAdvancedReadCacheSize = "閱讀快取大小"
    override val settingsAdvancedAppLanguageTitle = "應用程式介面語言"
    override val settingsAdvancedExportData = "匯出檔案"
    override val settingsAdvancedExportDataSummary =
        "儲存資料至外接儲存裝置，例如下載列表，快速搜尋列表"
    override val settingsAdvancedExportDataTo = { p0: String ->
        "已匯出資料至 %s"
            .format(p0)
    }
    override val settingsAdvancedExportDataFailed = "無法匯出資料"
    override val settingsAdvancedImportData = "匯入檔案"
    override val settingsAdvancedImportDataSummary = "從之前儲存的檔案匯入"
    override val settingsAdvancedImportDataSuccessfully = "成功將資料匯入"
    override val settingsAdvancedBackupFavorite = "備份收藏列表"
    override val settingsAdvancedBackupFavoriteSummary = "備份雲端收藏列表到本機"
    override val settingsAdvancedBackupFavoriteStart = { p0: String ->
        "正在備份收藏列表 %s"
            .format(p0)
    }
    override val settingsAdvancedBackupFavoriteNothing = "沒有可以備份的收藏列表"
    override val settingsAdvancedBackupFavoriteSuccess = "備份收藏列表成功"
    override val settingsAdvancedBackupFavoriteFailed = "備份收藏列表失敗"
    override val settingsAbout = "關於"
    override val settingsAboutDeclarationSummary = "EhViewer 與 E-Hentai.org 無任何關聯"
    override val settingsAboutAuthor = "作者"
    override val settingsAboutLatestRelease = "最新版本"
    override val settingsAboutSource = "原始碼"
    override val settingsAboutVersion = "版本號碼"
    override val settingsAboutCommitTime = { p0: String ->
        "於 %s 提交"
            .format(p0)
    }
    override val settingsAboutCheckForUpdates = "檢查更新"
    override val license = "授權條款"
    override val pleaseWait = "請稍候"
    override val cantReadTheFile = "無法讀取檔案"
    override val appLanguageSystem = "系統語言（預設）"
    override val cloudFavorites = "雲端收藏"
    override val localFavorites = "本機收藏"
    override val searchBarHint = { p0: String ->
        "搜尋 %s"
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
    override val deleteFavoritesDialogTitle = "移除收藏"
    override val deleteFavoritesDialogMessage = { p0: Int ->
        "將 %d 項收藏移除？"
            .format(p0)
    }
    override val moveFavoritesDialogTitle = "移動收藏"
    override val defaultFavoritesCollection = "預設收藏夾"
    override val defaultFavoritesWarning = "若啟用此項將無法新增收藏備註"
    override val letMeSelect = "讓我每次都選擇"
    override val favoriteNote = "收藏備註"
    override val collections = "收藏夾"
    override val errorSomethingWrongHappened = "被玩壞了"
    override val fromTheFuture = "來自未來"
    override val justNow = "剛剛"
    override val yesterday = "昨天"
    override val someDaysAgo = { p0: Int ->
        "%d 天前"
            .format(p0)
    }
    override val archive = "壓縮檔"
    override val archiveFree = "免費"
    override val archiveOriginal = "原始"
    override val archiveResample = "重新採樣"
    override val noArchives = "沒有壓縮檔"
    override val downloadArchiveStarted = "開始下載壓縮檔"
    override val downloadArchiveFailure = "下載失敗"
    override val downloadArchiveFailureNoHath = "下載壓縮檔需要 H@H 客戶端"
    override val currentFunds = "目前資金："
    override val insufficientFunds = "餘額不足"
    override val imageLimits = "圖片配額"
    override val imageLimitsSummary = "已用："
    override val resetCost = { p0: Int ->
        "花費 %d GP 重置"
            .format(p0)
    }
    override val reset = "重置"
    override val settingsPrivacy = "隱私"
    override val settingsPrivacySecure = "不允許螢幕擷取"
    override val settingsPrivacySecureSummary =
        "啟用後，將無法對本程式進行螢幕擷取，同時，將不會在系統任務切換器中顯示該程式的預覽內容，重新啟動本程式以套用此變更"
    override val clearSearchHistory = "清除裝置上的搜尋記錄"
    override val clearSearchHistorySummary = "移除曾在此裝置上進行過的搜尋"
    override val clearSearchHistoryConfirm = "清除搜尋記錄？"
    override val searchHistoryCleared = "已清除搜尋記錄"
    override val downloadService = "下載服務"
    override val keyFavoriteName = "收藏圖庫"
    override val blackDarkTheme = "純黑深色主題"
    override val harmonizeCategoryColor = "以動態顏色為分類顏色配色"
    override val backupBeforeUpdate = "更新前備份資料"
    override val useCiUpdateChannel = "使用 CI 更新頻道"
    override val sortBy = "排序方式"
    override val addedTimeDesc = "加入時間 (遞減)"
    override val addedTimeAsc = "加入時間 (遞增)"
    override val uploadedTimeDesc = "上傳時間 (遞減)"
    override val uploadedTimeAsc = "上傳時間 (遞增)"
    override val titleAsc = "標題 (遞減)"
    override val titleDesc = "標題 (遞增)"
    override val pageCountAsc = "頁數 (遞減)"
    override val pageCountDesc = "頁數 (遞增)"
    override val groupByDownloadLabel = "按下載標籤分組"
    override val downloadFilter = "過濾"
    override val downloadAll = "全部"
    override val downloadStartAllReversed = "全部開始（倒序）"
    override val settingsDownloadDownloadDelay = "下載延時"
    override val settingsDownloadDownloadDelaySummary = { p0: String ->
        "每次下載延時 %s 毫秒"
            .format(p0)
    }
    override val settingsDownloadDownloadTimeout = "下載超時（秒）"
    override val noBrowserInstalled = "請安裝一個瀏覽器。"
    override val toplistAlltime = "從始至終"
    override val toplistPastyear = "過去一年"
    override val toplistPastmonth = "過去一個月"
    override val toplistYesterday = "昨日"
    override val toplist = "排行"
    override val tagVoteDown = "不，這不是"
    override val tagVoteUp = "是的，這很正確"
    override val tagVoteSuccessfully = "投票成功"
    override val deleteSearchHistory = { p0: String ->
        "從搜尋記錄中刪除“%s”？"
            .format(p0)
    }
    override val actionAddTag = "增加標籤"
    override val actionAddTagTip = "增加新標籤"
    override val commentUserUploader = { p0: String ->
        "%s （上傳者）"
            .format(p0)
    }
    override val settingsEhMeteredNetworkWarning = "流量計費網路警告"
    override val meteredNetworkWarning = "正在使用流量計費網路"
    override val readFrom = { p0: Int ->
        "從第 %d 頁閱讀"
            .format(p0)
    }
    override val settingsEhRequestNews = "啟動時請求新聞頁面"
    override val settingsEhHideHvEvents = "隱藏 HV 事件通知"
    override val copyTrans = "複製翻譯"
    override val resetDownloadLocation = "恢復預設路徑"
    override val pickNewDownloadLocation = "選擇新路徑"
    override val dontShowAgain = "不再顯示"
    override val openSettings = "開啟設定"
    override val appLinkNotVerifiedMessage =
        "對於 Android 12 及更新的版本，您需要手動增加連結到已驗證連結才能在 EhViewer 中開啟 E-Hentai 連結。"
    override val appLinkNotVerifiedTitle = "應用程式連結未驗證"
    override val openByDefault = "預設開啟"
    override val settingsPrivacyRequireUnlock = "需要解鎖"
    override val settingsPrivacyRequireUnlockDelay = "鎖定延遲"
    override val settingsPrivacyRequireUnlockDelaySummary = { p0: String ->
        "離開程式並在 %s 分鐘內返回時不需要解鎖"
            .format(p0)
    }
    override val settingsPrivacyRequireUnlockDelaySummaryImmediately = "無論何時回到程式均要求解鎖"
    override val filterLabel = "隱藏項類型"
    override val archivePasswd = "壓縮檔密碼"
    override val archiveNeedPasswd = "壓縮檔需要密碼"
    override val passwdWrong = "密碼錯誤"
    override val passwdCannotBeEmpty = "密碼不能為空"
    override val listTileThumbSize = "詳情模式下縮圖大小"
    override val accountName = "帳號"
    override val preloadThumbAggressively = "積極地預載入縮圖"
    override val animateItems = "列表項目動畫"
    override val animateItemsSummary = "如遇崩潰/低幀率請嘗試停用此項"
    override val autoUpdates = "自動檢查更新"
    override val updateFrequencyNever = "從不"
    override val updateFrequencyDaily = "每天"
    override val updateFrequency3days = "每 3 天"
    override val updateFrequencyWeekly = "每週"
    override val updateFrequencyBiweekly = "每兩週"
    override val updateFrequencyMonthly = "每月"
    override val updateFailed = { p0: String ->
        "更新失敗：%s"
            .format(p0)
    }
    override val newVersionAvailable = "有新版本可用！"
    override val alreadyLatestVersion = "已是最新版本"
    override val permissionDenied = "沒有權限"
    override val downloadGalleryFirst = "請先下載圖庫！"
    override val exportAsArchive = "匯出成壓縮檔"
    override val exportAsArchiveSuccess = "匯出成功"
    override val exportAsArchiveFailed = "匯出失敗"
    override val actionSettings = "設定"
    override val actionRetry = "重試"
    override val actionShare = "分享"
    override val actionCopy = "複製"
    override val actionSave = "儲存"
    override val actionSaveTo = "儲存到…"
    override val prefCategoryGeneral = "一般"
    override val prefFullscreen = "全螢幕"
    override val prefPageTransitions = "翻頁轉場動畫"
    override val prefShowPageNumber = "顯示頁碼"
    override val prefShowReaderSeekbar = "顯示跳頁拖動條"
    override val prefDoubleTapToZoom = "雙擊縮放"
    override val prefCustomBrightness = "自訂亮度"
    override val prefCustomColorFilter = "色彩濾鏡"
    override val prefKeepScreenOn = "保持螢幕恆亮"
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
    override val prefRotationType = "預設螢幕方向"
    override val rotationFree = "自動"
    override val rotationForcePortrait = "鎖定直向"
    override val rotationForceLandscape = "鎖定橫向"
    override val customFilter = "濾鏡"
    override val decodeImageError = "無法載入該圖片"
    override val prefReadWithLongTap = "長按顯示"
    override val prefColorFilterMode = "濾鏡融合機制"
    override val filterModeMultiply = "色彩增值"
    override val filterModeScreen = "濾色"
    override val filterModeOverlay = "覆蓋"
    override val filterModeLighten = "減淡/變亮"
    override val filterModeDarken = "加深/變暗"
    override val prefCutoutShort = "使用螢幕凹口區域"
    override val actionMenu = "選單"
    override val webtoonSidePadding25 = "25%"
    override val webtoonSidePadding20 = "20%"
    override val webtoonSidePadding15 = "15%"
    override val webtoonSidePadding10 = "10%"
    override val webtoonSidePadding0 = "無"
    override val prefWebtoonSidePadding = "頁緣留白"
    override val verticalPlusViewer = "垂直連貫"
    override val grayBackground = "灰色"
    override val viewer = "閱讀模式"
    override val tappingInvertedBoth = "水平 + 垂直"
    override val tappingInvertedVertical = "垂直"
    override val tappingInvertedHorizontal = "水平"
    override val tappingInvertedNone = "無"
    override val prefCategoryReadingMode = "閱讀模式"
    override val prefReadWithTappingInverted = "反轉輕觸區域"
    override val prefViewerNav = "輕觸區域"
    override val edgeNav = "邊緣式"
    override val kindlishNav = "Kindle 式"
    override val lNav = "L 式"
    override val rightAndLeftNav = "左右式"
    override val navZoneRight = "右邊"
    override val navZoneLeft = "左邊"
    override val navZoneNext = "下一頁"
    override val navZonePrev = "上一頁"
    override val rotationLandscape = "橫向"
    override val rotationPortrait = "直向"
    override val rotationType = "螢幕方向"
    override val prefGrayscale = "灰階"
    override val automaticBackground = "自動"
    override val prefInvertedColors = "反轉"
    override val labelDefault = "預設"
    override val webtoonSidePadding5 = "5%"
    override val prefLandscapeZoom = "縮放橫向圖片"
    override val prefNavigatePan = "輕觸時移動圖片"
    override val rotationReversePortrait = "顛倒直向"
    override val disabledNav = "停用"
    override val wideColorGamut = "使用 Display P3 色彩空間"
    override val settingsEhRequestNewsTimepicker = "設定請求新聞頁面的時間"
    override val darkTheme = "深色主題"
    override val darkThemeFollowSystem = "跟隨系統"
    override val darkThemeOff = "總是關閉"
    override val darkThemeOn = "總是開啟"
    override val prefCropBorders = "邊緣裁剪"
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
