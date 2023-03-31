$(document).ready(function(event) {
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
	
	function validateForm() {
        var password1 = document.getElementById("password1").value;
        var password2 = document.getElementById("password2").value;
        if (password1 != password2) {
            alert("Passwords do not match!");
            return false;
        }
        return true;
    }  
  
});