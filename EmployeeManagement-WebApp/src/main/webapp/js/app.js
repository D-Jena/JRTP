$(document).ready(function() {
	$("#stateId").change(function() {
	    $("#distId").find('option').remove();
	    $('<option>').val('').text('-Select-').appendTo("#distId");
	    
	    var stateId = $("#stateId").val();
	    $.ajax({
	      type: "GET",
	      url: "getDistricts?sid=" + stateId,
	      success: function(data) {
	        $.each(data, function (distId, distName) {
	           $('<option>').val(distId).text(distName).appendTo("#distId");
	        });
	      }
	    });
	});

});

function validatePassword() {
    const passwordOne = document.getElementById("passwordOne").value;
    const passwordTwo = document.getElementById("passwordTwo").value;
    if (passwordOne !== passwordTwo) {
        alert("Passwords do not match!");
        return false;
    }
    return true;
}