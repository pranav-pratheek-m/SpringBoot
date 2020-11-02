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
			
			var startDate = vehicleHire.startDate.substr(0,10);
			var endDate = vehicleHire.endDate.substr(0,10);
			$('#startDateEdit').val(startDate);
			$('#endDateEdit').val(endDate);
			
			$('#remarksEdit').val(vehicleHire.remarks);
			$('#ddlSupplierEdit').val(vehicleHire.supplierid);
			$('#priceEdit').val(vehicleHire.price);			
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
			
			var startDate = vehicleHire.startDate.substr(0,10);
			var endDate = vehicleHire.endDate.substr(0,10);
			$('#startDateDetails').val(startDate);
			$('#endDateDetails').val(endDate);
			
			$('#remarksDetails').val(vehicleHire.remarks);
			$('#ddlSupplierDetails').val(vehicleHire.supplierid);
			$('#priceDetails').val(vehicleHire.price);
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