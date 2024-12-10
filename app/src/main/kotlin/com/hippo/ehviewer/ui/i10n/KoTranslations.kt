package com.hippo.ehviewer.ui.i10n

object KoTranslations : Translations by EnTranslations {
    override val homepage = "홈"

    override val whatsHot = "인기 갤러리"

    override val favourite = "즐겨찾기"

    override val history = "방문 기록"

    override val downloads = "다운로드"

    override val settings = "설정"

    override val username = "사용자 이름"

    override val password = "비밀번호"

    override val signIn = "로그인"

    override val register = "회원가입"

    override val signInViaWebview = "WebView를 통하여 로그인"

    override val signInFirst = "먼저 로그인하세요."

    override val textIsEmpty = "텍스트가 비어 있습니다."

    override val waring = "경고"

    override val invalidDownloadLocation = "다운로드 위치가 잘못되었습니다. 설정을 확인하세요."

    override val clipboardGalleryUrlSnackMessage = "클립보드에 갤러리 주소가 있습니다."

    override val clipboardGalleryUrlSnackAction = "보기"

    override val errorTimeout = "시간 초과"

    override val errorUnknownHost = "알 수 없는 호스트"

    override val errorRedirection = "너무 많은 서버 리디렉션"

    override val errorSocket = "네트워크 오류"

    override val errorUnknown = "이상함"

    override val errorCantFindActivity = "앱을 찾을 수 없음"

    override val errorCannotParseTheUrl = "URL을 분석할 수 없음"

    override val errorDecodingFailed = "디코딩 실패"

    override val errorReadingFailed = "읽기 실패"

    override val errorOutOfRange = "범위 초과"

    override val errorParseError = "구문 분석 오류"

    override val error509 = "509"

    override val errorInvalidUrl = "잘못된 URL"

    override val errorGetPtokenError = "pToken 획득 오류"

    override val errorCantSaveImage = "이미지를 저장할 수 없음"

    override val errorInvalidNumber = "잘못된 번호"

    override val appWaring = "이 앱의 내용은 인터넷에서 받아옵니다. 이 앱을 사용하기 위해서는 받아온 내용 중 일부가 사용자에게 가할 수 있는 신체적 또는 정신적 피해를 감수해야 합니다."

    override val errorUsernameCannotEmpty = "사용자 이름은 비워둘 수 없습니다."

    override val errorPasswordCannotEmpty = "비밀번호는 비워둘 수 없습니다."

    override val guestMode = "로그인 없이 사용"

    override val signInFailed = "로그인 실패"

    override val getIt = "알겠습니다"

    override val galleryListSearchBarHintExhentai = "ExHentai 검색"

    override val galleryListSearchBarHintEHentai = "E-Hentai 검색"

    override val galleryListSearchBarOpenGallery = "갤러리 열기"

    override val galleryListEmptyHit = "The World is Big and the panda sit alone"

    override val keywordSearch = "키워드 검색"

    override val imageSearch = "이미지 검색"

    override val searchImage = "이미지 검색"

    override val searchSh = "Expunged 갤러리 표시"

    override val searchSto = "토렌트 파일이 있는 갤러리만 검색"

    override val searchSr = "최소 평점"

    override val selectImage = "이미지 선택"

    override val selectImageFirst = "먼저 이미지를 선택해 주세요."

    override val addToFavourites = "즐겨찾기에 추가"

    override val quickSearch = "빠른 검색"

    override val quickSearchTip = "빠른 검색을 추가하려면 \"+\" 버튼을 누르세요."

    override val addQuickSearchDialogTitle = "빠른 검색 추가"

    override val nameIsEmpty = "이름이 비어 있습니다."

    override val delete = "삭제"

    override val addQuickSearchTip = "갤러리 목록의 상태가 빠른 검색으로 저장됩니다. 검색 패널의 상태를 저장하려면 먼저 검색을 해야 합니다."

    override val readme = "README"

    override val imageSearchNotQuickSearch = "이미지 검색은 빠른 검색에 추가할 수 없습니다."

    override val duplicateQuickSearch = { p0: String ->
        "이미 같은 내용의 빠른 검색 항목이 있습니다. 이름은 \"%s\"입니다."
            .format(p0)
    }

    override val duplicateName = "같은 이름의 항목이 이미 있습니다."

    override val goToHint = { p0: Int, p1: Int ->
        "페이지 %d, 총 %d 페이지"
            .format(p0, p1)
    }

    override val star2 = "2개"

    override val star3 = "3개"

    override val star4 = "4개"

    override val star5 = "5개"

    override val download = "다운로드"

    override val read = "읽기"

    override val torrentCount = { p0: Int ->
        "토렌트 (%d)"
            .format(p0)
    }

    override val share = "공유"

    override val rate = "평가"

    override val similarGallery = "유사"

    override val searchCover = "커버 검색"

    override val noTags = "태그 없음"

    override val noComments = "코멘트 없음"

    override val noMoreComments = "코멘트가 더 없음"

    override val moreComment = "코멘트 더 보기"

    override val refresh = "새로고침"

    override val openInOtherApp = "다른 앱에서 열기"

    override val rateSuccessfully = "평가를 남겼습니다."

    override val rateFailed = "평가에 실패했습니다."

    override val noTorrents = "토렌트 없음"

    override val torrents = "토렌트"

    override val notFavorited = "즐겨찾기에 없음"

    override val addFavoritesDialogTitle = "즐겨찾기에 추가"

    override val addToFavoriteSuccess = "즐겨찾기에 추가했습니다."

    override val removeFromFavoriteSuccess = "즐겨찾기에서 제거했습니다."

    override val addToFavoriteFailure = "즐겨찾기에 추가하지 못했습니다."

    override val removeFromFavoriteFailure = "즐겨찾기에서 제거하지 못했습니다."

    override val galleryInfo = "갤러리 정보"

    override val copiedToClipboard = "클립보드에 복사했습니다."

    override val keyGid = "GID"

    override val keyToken = "토큰"

    override val keyUrl = "주소"

    override val keyTitle = "제목"

    override val keyTitleJpn = "일본어 제목"

    override val keyThumb = "섬네일"

    override val keyCategory = "카테고리"

    override val keyUploader = "업로더"

    override val keyPosted = "날짜"

    override val keyParent = "부모"

    override val keyVisible = "가시성"

    override val keyLanguage = "언어"

    override val keyPages = "페이지"

    override val keySize = "크기"

    override val keyFavoriteCount = "즐겨찾기\n횟수"

    override val keyFavorited = "즐겨찾기됨"

    override val keyRatingCount = "평가 횟수"

    override val keyRating = "평가"

    override val keyTorrents = "토렌트"

    override val keyTorrentUrl = "토렌트 주소"

    override val galleryComments = "갤러리 코멘트"

    override val commentSuccessfully = "코멘트를 남겼습니다."

    override val commentFailed = "코멘트를 남기지 못했습니다."

    override val copyCommentText = "코멘트 텍스트 복사"

    override val voteUp = "추천 (Vote up)"

    override val cancelVoteUp = "추천 취소"

    override val voteDown = "비추천 (Vote down)"

    override val cancelVoteDown = "비추천 취소"

    override val voteUpSuccessfully = "추천했습니다."

    override val cancelVoteUpSuccessfully = "추천을 취소했습니다."

    override val voteDownSuccessfully = "비추천했습니다."

    override val cancelVoteDownSuccessfully = "비추천을 취소했습니다."

    override val voteFailed = "추천/비추천에 실패했습니다."

    override val checkVoteStatus = "추천/비추천 상태 보기"

    override val goTo = "이동"

    override val sceneDownloadTitle = { p0: String ->
        "다운로드 - %s"
            .format(p0)
    }

    override val noDownloadInfo = "다운로드한 항목이 여기에 표시됩니다."

    override val downloadStateNone = "유휴 상태"

    override val downloadStateWait = "대기 중"

    override val downloadStateDownloading = "다운로드 중"

    override val downloadStateDownloaded = "다운로드함"

    override val downloadStateFailed = "실패함"

    override val downloadStateFailed2 = { p0: Int ->
        "%d 남아 있음"
            .format(p0)
    }

    override val downloadStateFinish = "완료"

    override val stat509AlertTitle = "509 경고"

    override val stat509AlertText = "이미지 제한에 도달하였습니다. 다운로드를 멈추고 잠시 쉬세요."

    override val statDownloadDoneTitle = "다운로드 완료"

    override val statDownloadDoneTextSucceeded = { p0: Int ->
        "%d 성공"
            .format(p0)
    }

    override val statDownloadDoneTextFailed = { p0: Int ->
        "%d 실패"
            .format(p0)
    }

    override val statDownloadDoneTextMix = { p0: Int, p1: Int ->
        "%d 성공, %d 실패"
            .format(p0, p1)
    }

    override val statDownloadDoneLineSucceeded = { p0: String ->
        "성공: %s"
            .format(p0)
    }

    override val statDownloadDoneLineFailed = { p0: String ->
        "실패: %s"
            .format(p0)
    }

    override val downloadRemoveDialogTitle = "다운로드 항목 제거"

    override val downloadRemoveDialogMessage = { p0: String ->
        "%s 항목을 다운로드 목록에서 제거하시겠습니까?"
            .format(p0)
    }

    override val downloadRemoveDialogMessage2 = { p0: Int ->
        "%d개 항목을 다운로드 목록에서 제거하시겠습니까?"
            .format(p0)
    }

    override val downloadRemoveDialogCheckText = "이미지 파일 삭제"

    override val statDownloadActionStopAll = "모두 중지"

    override val defaultDownloadLabelName = "기본"

    override val downloadMoveDialogTitle = "이동"

    override val downloadLabels = "다운로드 레이블"

    override val downloadStartAll = "모두 시작"

    override val downloadStopAll = "모두 중지"

    override val downloadResetReadingProgress = "독서 진행도 초기화"

    override val resetReadingProgressMessage = "다운로드한 모든 갤러리의 독서 진행도를 초기화하시겠습니까?"

    override val downloadServiceLabel = "EhViewer 다운로드 서비스"

    override val downloadSpeedText = { p0: String ->
        "%s"
            .format(p0)
    }

    override val downloadSpeedText2 = { p0: String, p1: String ->
        "%s, %s 남음"
            .format(p0, p1)
    }

    override val rememberDownloadLabel = "다운로드 레이블 기억"

    override val defaultDownloadLabel = "기본 다운로드 레이블"

    override val addedToDownloadList = "다운로드 목록에 추가됨"

    override val add = "추가"

    override val newLabelTitle = "새 레이블"

    override val labelTextIsEmpty = "레이블 텍스트가 비어 있습니다."

    override val labelTextIsInvalid = "\"기본\"은 레이블 이름으로 사용할 수 없습니다."

    override val labelTextExist = "이미 있는 레이블입니다."

    override val renameLabelTitle = "레이블 이름 바꾸기"

    override val noHistory = "읽은 갤러리가 여기에 표시됩니다."

    override val clearAll = "모두 지우기"

    override val clearAllHistory = "모든 방문 기록을 지우시겠습니까?"

    override val filterTitle = "제목"

    override val filterUploader = "업로더"

    override val filterTag = "태그"

    override val filterTagNamespace = "태그 네임스페이스"

    override val showDefinition = "정의 표시"

    override val uConfig = "E-Hentai 설정"

    override val applyTip = "설정을 저장하려면 체크 표시를 누르세요."

    override val shareImage = "이미지 공유"

    override val imageSaved = { p0: String ->
        "이미지를 %s 경로에 저장함"
            .format(p0)
    }

    override val settingsEh = "EH"

    override val settingsEhSignOut = "로그아웃"

    override val settingsEhIdentityCookiesSigned = "식별용 쿠키를 사용하여 이 계정으로 로그인할 수 있습니다.<br><b>안전하게 보관하세요.</b>"

    override val settingsEhIdentityCookiesGuest = "로그인 상태가 아닙니다."

    override val settingsUConfig = "E-Hentai 설정"

    override val settingsUConfigSummary = "E-Hentai 사이트의 설정 페이지를 엽니다."

    override val settingsEhGallerySite = "갤러리 사이트"

    override val settingsEhListMode = "목록 모드"

    override val settingsEhListModeDetail = "자세히"

    override val settingsEhListModeThumb = "섬네일"

    override val settingsEhDetailSize = "상세 정보 크기"

    override val settingsEhDetailSizeLong = "길게"

    override val settingsEhDetailSizeShort = "짧게"

    override val settingsEhShowJpnTitle = "일본어 제목 표시"

    override val settingsEhShowGalleryPages = "갤러리 페이지 수 표시"

    override val settingsEhShowGalleryPagesSummary = "갤러리 목록에 해당 갤러리의 페이지 수를 표시합니다"

    override val settingsEhShowTagTranslations = "번역된 태그 표시"

    override val settingsEhShowTagTranslationsSummary = "영어 태그 대신 번역된 태그를 표시합니다. 데이터 파일을 다운로드하는데 시간이 걸립 수 있습니다."

    override val settingsEhTagTranslationsSource = "Placeholder"

    override val settingsEhTagTranslationsSourceUrl = "https://placeholder"

    override val settingsDownload = "다운로드"

    override val settingsDownloadDownloadLocation = "다운로드 위치"

    override val settingsDownloadCantGetDownloadLocation = "다운로드 위치를 가져올 수 없습니다."

    override val settingsDownloadMediaScan = "미디어 스캔 허용"

    override val settingsDownloadMediaScanSummaryOn = "다른 사람들에게 갤러리 앱을 들키지 마세요."

    override val settingsDownloadMediaScanSummaryOff = "대부분의 갤러리 앱에서 다운로드 경로에 있는 사진을 무시합니다."

    override val settingsDownloadConcurrency = "다중 스레드 다운로드"

    override val settingsDownloadConcurrencySummary = { p0: String ->
        "%s개 이미지까지"
            .format(p0)
    }

    override val settingsDownloadPreloadImage = "이미지 미리 불러오기"

    override val settingsDownloadPreloadImageSummary = { p0: String ->
        "다음 %s개 이미지를 미리 불러옴"
            .format(p0)
    }

    override val settingsDownloadDownloadOriginImage = "원본 이미지 다운로드"

    override val settingsDownloadDownloadOriginImageSummary = "이 옵션은 위험합니다! 509 오류가 발생할 수 있습니다."

    override val settingsDownloadRestoreDownloadItems = "다운로드 항목 복구"

    override val settingsDownloadRestoreDownloadItemsSummary = "다운로드 위치에 존재하는 모든 다운로드 항목 복구"

    override val settingsDownloadRestoreNotFound = "복구할 다운로드 항목을 찾을 수 없습니다."

    override val settingsDownloadRestoreFailed = "복구하지 못했습니다."

    override val settingsDownloadRestoreSuccessfully = { p0: Int ->
        "%d개 항목을 복구했습니다."
            .format(p0)
    }

    override val settingsDownloadCleanRedundancy = "잉여 파일 삭제"

    override val settingsDownloadCleanRedundancySummary = "다운로드 위치에 존재하지만 다운로드 목록에는 없는 갤러리 이미지 제거"

    override val settingsDownloadCleanRedundancyNoRedundancy = "잉여 파일이 없습니다."

    override val settingsDownloadCleanRedundancyDone = { p0: Int ->
        "잉여 파일을 청소했습니다. 모두 %d개 항목을 지웠습니다."
            .format(p0)
    }

    override val settingsAdvanced = "고급"

    override val settingsAdvancedSaveParseErrorBody = "파싱 오류 시 HTML 내용 저장"

    override val settingsAdvancedSaveParseErrorBodySummary = "HTML 파일에는 개인 정보가 포함될 수 있습니다."

    override val settingsAdvancedSaveCrashLog = "앱 충돌 시 로그 저장"

    override val settingsAdvancedSaveCrashLogSummary = "충돌 로그는 개발자가 버그를 수정하는 데 도움이 됩니다."

    override val settingsAdvancedDumpLogcat = "로그캣 덤프"

    override val settingsAdvancedDumpLogcatSummary = "외부 저장소에 로그캣 저장"

    override val settingsAdvancedDumpLogcatFailed = "로그캣을 덤프하지 못했습니다."

    override val settingsAdvancedDumpLogcatTo = { p0: String ->
        "%s 경로에 로그캣을 저장했습니다."
            .format(p0)
    }

    override val settingsAdvancedReadCacheSize = "읽기 캐시 크기"

    override val settingsAdvancedAppLanguageTitle = "앱 언어 (Language)"

    override val settingsAdvancedExportData = "데이터 내보내기"

    override val settingsAdvancedExportDataSummary = "다운로드 목록, 빠른 검색 목록 등의 데이터를 외부 저장소에 저장"

    override val settingsAdvancedExportDataTo = { p0: String ->
        "%s 경로에 데이터를 내보냈습니다."
            .format(p0)
    }

    override val settingsAdvancedExportDataFailed = "데이터를 내보내지 못했습니다."

    override val settingsAdvancedImportData = "데이터 가져오기"

    override val settingsAdvancedImportDataSummary = "이전에 저장한 데이터 불러오기"

    override val settingsAdvancedImportDataSuccessfully = "데이터를 가져왔습니다."

    override val settingsAbout = "앱 정보"

    override val settingsAboutDeclarationSummary = "EhViewer는 E-Hentai.org 사이트와 아무런 관계가 없습니다."

    override val settingsAboutAuthor = "개발자"

    override val settingsAboutSource = "소스 코드"

    override val settingsAboutVersion = "빌드 버전"

    override val settingsAboutCheckForUpdates = "업데이트 확인"

    override val cantReadTheFile = "파일을 읽을 수 없습니다."

    override val appLanguageSystem = "시스템 언어 (기본값)"

    override val pleaseWait = "잠시만 기다려 주세요."

    override val cloudFavorites = "클라우드 즐겨찾기"

    override val localFavorites = "로컬 즐겨찾기"

    override val searchBarHint = { p0: String ->
        "%s 검색"
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

    override val deleteFavoritesDialogTitle = "즐겨찾기에서 삭제"

    override val deleteFavoritesDialogMessage = { p0: Int ->
        "%d개 항목을 즐겨찾기에서 삭제하시겠습니까?"
            .format(p0)
    }

    override val moveFavoritesDialogTitle = "즐겨찾기 이동"

    override val defaultFavoritesCollection = "기본 즐겨찾기 컬렉션"

    override val letMeSelect = "직접 선택"

    override val collections = "컬렉션"

    override val errorSomethingWrongHappened = "뭔가 잘못되었습니다."

    override val fromTheFuture = "미래에"

    override val justNow = "방금"

    override val yesterday = "어제"

    override val someDaysAgo = { p0: Int ->
        "%d일 전"
            .format(p0)
    }

    override val archive = "아카이브"

    override val noArchives = "아카이브 없음"

    override val downloadArchiveStarted = "아카이브 다운로드가 시작되었습니다."

    override val downloadArchiveFailure = "아카이브 다운로드에 실패했습니다."

    override val downloadArchiveFailureNoHath = "아카이브를 다운로드하려면 H@H 클라이언트가 필요합니다."

    override val settingsPrivacy = "개인 정보"

    override val settingsPrivacySecure = "화면 캡처 허용 안 함"

    override val settingsPrivacySecureSummary = "이 앱에서 스크린샷을 찍을 수 없게 하며, \"최근 앱\" 화면에서 앱의 내용을 보이지 않게 합니다."

    override val downloadService = "다운로드 서비스"

    override val favoriteName = "즐겨찾기"

    override val darkTheme = "어두운 테마"

    override val darkThemeFollowSystem = "시스템 설정"

    override val darkThemeOff = "항상 꺼짐"

    override val darkThemeOn = "항상 켜짐"

    override val pageCount = { quantity: Int ->
        when (quantity) {
            else -> "%d 페이지"
        }.format(quantity)
    }

    override val someMinutesAgo = { quantity: Int ->
        when (quantity) {
            else -> "%d분 전"
        }.format(quantity)
    }

    override val someHoursAgo = { quantity: Int ->
        when (quantity) {
            else -> "%d시간 전"
        }.format(quantity)
    }

    override val second = { quantity: Int ->
        when (quantity) {
            else -> "초"
        }.format(quantity)
    }

    override val minute = { quantity: Int ->
        when (quantity) {
            else -> "분"
        }.format(quantity)
    }

    override val hour = { quantity: Int ->
        when (quantity) {
            else -> "시간"
        }.format(quantity)
    }

    override val day = { quantity: Int ->
        when (quantity) {
            else -> "일"
        }.format(quantity)
    }

    override val year = { quantity: Int ->
        when (quantity) {
            else -> "년"
        }.format(quantity)
    }
}
