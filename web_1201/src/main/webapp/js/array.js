$(function () {
    var msg =  [{"userid":"01","username":"大娃","address":"树上","mobile":"101"},
        {"userid":"02","username":"二娃","address":"爷爷家","mobile":"102"},
        {"userid":"03","username":"三娃","address":"藤","mobile":"103"},
        {"userid":"04","username":"四娃","address":"大山","mobile":"104"},
    ]
    var re = "";
    $.each(msg,function (i, ele) {
        // re += ele.userid +""+ele.username+""+ele.address+""+ele.mobile;
        $("#this").append("<option value="+ele+">"+ele.userid+"-"+ele.username+"-"+ele.address+ele.mobile+"</option>");
    })

    var re0 = "";
    $.each(msg,function (i, ele) {
        $("#this2").append("<tr>"+"<td>"+ele.userid+"</td>"+"<td>"+ele.username+"</td>"+"<td>"+ele.address+"</td>"+"<td>"+ele.mobile+"</td>"+"</tr>>");
    })
})