/*工具类*/
var CoreUtil = (function () {
    var coreUtil = {};

    /*GET*/
    coreUtil.sendGet = function(url, params, ft){
        this.sendAJAX(url, params, ft, "GET")
    }

    /*POST*/
    coreUtil.sendPost = function(url, params, ft){
        this.sendAJAX(url, JSON.stringify(params), ft, "POST")
    }
    /*PUT*/
    coreUtil.sendPut = function(url, params, ft){
        this.sendAJAX(url, JSON.stringify(params), ft, "PUT")
    }
    /*DELETE*/
    coreUtil.sendDelete = function(url, params, ft){
        this.sendAJAX(url, JSON.stringify(params), ft, "DELETE")
    }


    /*ajax*/
    coreUtil.sendAJAX = function(url, params, ft, method){
        var loadIndex = top.layer.load(0, {shade: false});
        $.ajax({
            url: url,
            cache: false,
            async: true,
            data: params,
            type: method,
            dataType: "json",
            success: function (res) {
                top.layer.close(loadIndex);
                if (res.code==200){
                    if(ft!=null&&ft!=undefined){
                        ft(res);
                    }
                } else {
                    layer.msg(res.msg);
                }
            },
            error:function (XMLHttpRequest, textStatus, errorThrown) {
                top.layer.close(loadIndex);
                if(XMLHttpRequest.status==404){
                    top.window.location.href="/index/404";
                }else{
                    layer.msg("服务器好像除了点问题！请稍后试试");
                }
            }
        })
    }


    /*存入本地缓存*/
    coreUtil.setData = function(key, value){
        layui.data('LocalData',{
            key :key,
            value: value
        })
    };
    /*从本地缓存拿数据*/
    coreUtil.getData = function(key){
        var localData = layui.data('LocalData');
        return localData[key];
    };

    //判断字符是否为空的方法
    coreUtil.isEmpty = function(obj){
        if(typeof obj == "undefined" || obj == null || obj == ""){
            return true;
        }else{
            return false;
        }
    }

    //字典数据回显
    coreUtil.selectDictLabel = function (datas, value) {
        datas = JSON.parse(datas);
        var label = "";
        $.each(datas, function(index, dict) {
            if (dict.value == ('' + value)) {
                label = dict.label;
                return false;
            }
        });
        //匹配不到，返回未知
        if (CoreUtil.isEmpty(label)) {
            return "未知";
        }
        return label;
    }


    return coreUtil;
})(CoreUtil, window);
