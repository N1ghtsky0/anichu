$(document).ready(function () {
    const currentPage = Number($("#page").val());
    $("#pre_btn").attr("href", "/anime?page="+(currentPage-1));
    $("#next_btn").attr("href", "/anime?page="+(currentPage+1));

    if (currentPage < 2) {
        $("#pre_btn").addClass("disabled");
    } else {
        $("#pre_btn").removeClass("disabled");
    }

    if ($("#isLast").val() === "true") {
        $("#next_btn").addClass("disabled");
    } else {
        $("#next_btn").removeClass("disabled");
    }
});