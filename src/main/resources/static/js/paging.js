/**
 *
 * @param url {string}
 * @Param page {number}
 * @param success {function}
 * @param fail {function}
 */
function ajaxPaging(url, page, success, fail) {
    $.ajax({
        url: url + '&page=' + page,
        method: 'GET',
        dataType: 'json'
    })
        .done(function (json) {
            success(json);
            initPagination(json.pageable.pageNumber, json.totalPages, json.first, json.last);
        })
        .fail(function (xhr, status, errorThrown) {
            fail();
        });
}

/**
 *
 * @param currentPage {number}
 * @param totalPage {number}
 * @param isFirst {boolean}
 * @param isLast {boolean}
 */
function initPagination(currentPage, totalPage, isFirst, isLast) {
    /** @type {string} */
    let result = '';

    if (isFirst) {
        result += '<li class="page-item disabled first"><button class="page-link" tabindex="-1" aria-disabled="true">Newer</button></li>';
    } else {
        result += '<li class="page-item"><button class="page-link" tabindex="-1" onclick="commentPaging(' + Math.max(0, currentPage - 10) + ')">Newer</button></li>';
    }

    /** @type {int} */
    const pageStartNum = Math.floor(currentPage / 10) * 10;

    for (let pageIdx = 0; pageIdx < Math.min((totalPage - pageStartNum), 10); pageIdx++) {
        if (pageStartNum + pageIdx === currentPage) {   //현재 페이지일 경우 active
            result += '<li class="page-item active" aria-current="page"><button class="page-link" onclick="commentPaging(' + (pageStartNum + pageIdx) + ')">' + (pageStartNum + pageIdx + 1) + '</button></li>';
        } else {
            result += '<li class="page-item"><button class="page-link" onclick="commentPaging(' + (pageStartNum + pageIdx) + ')">' + (pageStartNum + pageIdx + 1) + '</button></li>';
        }
    }

    if (isLast) {
        result += '<li class="page-item disabled"><button class="page-link" aria-disabled="true">Older</button></li>';
    } else {
        result += '<li class="page-item"><button class="page-link" onclick="commentPaging(' + Math.min(currentPage + 10, totalPage - 1) + ')">Older</button></li>';
    }

    $(".pagination").html(result);

}

/** @param page {number} */
function commentPaging(page) {
    const animeSeq = window.location.pathname.split("/").at(-1);
    ajaxPaging('/comment?seq=' + animeSeq, page, updateCommentWrap, AjaxCommentFailFunc);
}