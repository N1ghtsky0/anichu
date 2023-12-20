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
        result += '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1" aria-disabled="true">Newer</a></li>';
    } else {
        result += '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">Newer</a></li>';
    }

    /** @type {int} */
    const pageStartNum = Math.floor(currentPage / 10) * 10 + 1;

    for (let pageIdx = 0; pageIdx < Math.min((totalPage - pageStartNum + 2), 10); pageIdx++) {
        if (pageStartNum + pageIdx === currentPage + 1) {   //현재 페이지일 경우 active
            result += '<li class="page-item active" aria-current="page"><a class="page-link" href="#!">' + (pageStartNum + pageIdx) + '</a></li>';
        } else {
            result += '<li class="page-item"><a class="page-link" href="#!">' + (pageStartNum + pageIdx) + '</a></li>';
        }
    }

    if (isLast) {
        result += '<li class="page-item"><a class="page-link" href="#!" aria-disabled="true">Older</a></li>';
    } else {
        result += '<li class="page-item"><a class="page-link" href="#!">Older</a></li>';
    }

    $(".pagination").html(result);

}