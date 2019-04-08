window.onload = function (ev) {
    var clipboard = new ClipboardJS(".copy-btn");
    clipboard.on("success", function (e) {
        layer.msg("复制到剪切板成功")
    });
    clipboard.on("error", function (e) {
        layer.msg("复制到剪切板失败")
    })
};

var url = window.location.href;
$(".url").html(url.substr(url.indexOf("//") + 2));

function customGenerate() {
    var customYwz = $("#custom-ywz").val();
    var customDwz = $("#custom-dwz").val();
    if (!judgeYwz(customYwz)) {
        return;
    }
    if (customDwz == null || customDwz == "") {
        layer.tips("请输入您想要的短网址后缀", "#custom-dwz");
        return;
    }
    generateDwz(customYwz, customDwz);
}

function systemGenerate() {
    var customYwz = $("#custom-ywz").val();
    if (!judgeYwz(customYwz)) {
        return;
    }
    generateDwz(customYwz, null);
}

function judgeYwz(ywz) {
    if (!(ywz.indexOf("http://") == 0 || ywz.indexOf("https://") == 0)) {
        layer.msg("网址格式不正确，需要加上http://或者https://");
        return false;
    }
    return true;
}

function generateDwz(ywz, dwz) {
    $.post(Config.host + "/dwz/createDwz", {
        dwz: dwz,
        ywz: ywz
    }, function (data) {
        console.log(data);
        if (data.state == false) {
            layer.msg(data.msg);
            return;
        }
        $(".res").show();
        $("#custom-dwz").val(data.dwz);
        $("#generated-dwz").html(url + data.dwz);
        $("#generated-ywz").html(ywz);
    });
}