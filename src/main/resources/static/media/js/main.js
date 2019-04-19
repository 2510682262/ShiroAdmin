function sub(formid,cb) {
    $.ajax({
        url:$("#"+formid)[0].action,
        method:$("#"+formid)[0].method,
        data:$("#"+formid).serialize(),
        success:cb
    })
}
function subForm(formid,url) {
    $.ajax({
        url:$("#"+formid)[0].action,
        method:$("#"+formid)[0].method,
        data:$("#"+formid).serialize(),
        success:function (obj) {
            if(obj.code==1){
                $("#dvcontent").html("").load(url);
            }
        }
    })
}
function searchArray(v,arr) {
    var r=false;
    for(var i=0;i<arr.length;i++){
        if(arr[i]==v){
            r=true;
            break;
        }
    }
    return r;
}