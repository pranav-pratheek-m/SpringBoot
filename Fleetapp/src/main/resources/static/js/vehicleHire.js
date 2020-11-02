/**
 * 
 */

$('document').ready(function() {	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleHire, status){
			$('#idEdit').val(vehicleHire.id);
			
			$('#ddlVehicleEdit').val(vehicleHire.vehicleid);
			$('#ddlClientEdit').val(vehicleHire.clientid);
			$('#ddlLocationEdit').val(vehicleHire.locationid);	
					
			
			var timeOut = vehicleHire.timeOut.substr(0,10);
			var dateOut = vehicleHire.dateOut.substr(0,10);
			var timeIn = vehicleHire.timeIn.substr(0,10);
			var dateIn = vehicleHire.dateIn.substr(0,10);
			
			$('#timeOutEdit').val(dateIn);
			$('#dateOutEdit').val(dateOut);
			$('#timeInEdit').val(vehicleHire.timeIn);
			$('#timeOutEdit').val(vehicleHire.timeOut);
			
			$('#priceEdit').val(vehicleHire.price);
			$('#remarksEdit').val(vehicleHire.remarks);
						
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleHire, status){
			$('#idDetails').val(vehicleHire.id);
			
			$('#ddlVehicleDetails').val(vehicleHire.vehicleid);
			$('#ddlClientDetails').val(vehicleHire.clientid);
			$('#ddlLocationDetails').val(vehicleHire.locationid);	
					
			
			var timeOut = vehicleHire.timeOut.substr(0,10);
			var dateOut = vehicleHire.dateOut.substr(0,10);
			var timeIn = vehicleHire.timeIn.substr(0,10);
			var dateIn = vehicleHire.dateIn.substr(0,10);
			
			$('#timeOutDetails').val(dateIn);
			$('#dateOutDetails').val(dateOut);
			$('#timeInDetails').val(vehicleHire.timeIn);
			$('#timeOutDetails').val(vehicleHire.timeOut);
			
			$('#priceDetails').val(vehicleHire.price);
			$('#remarksDetails').val(vehicleHire.remarks);
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();		
	});	
});