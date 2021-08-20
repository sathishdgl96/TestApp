$('#userlink').click(function(e){
console.log("triggerred");
    e.preventDefault();
    $.ajax({
        type: "GET",
        url: "/onboarding",
        data: { },
        success: function(data){
            $('#maincontent').html(data);
        }
    });
});
