$('document').ready(function() {	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicle, status){
			var acDate = vehicle.acquisitionDate.substr(0,10);
			$('#acquisitionDateEdit').val(acDate);
			$('#descriptionEdit').val(vehicle.description);
			$('#ddlEmployeeEdit').val(vehicle.employeeid);
			$('#fuelCapacityEdit').val(vehicle.fuelCapacity);
			$('#idEdit').val(vehicle.id);
			$('#ddlLocationEdit').val(vehicle.locationid);
			$('#nameEdit').val(vehicle.name);
			$('#netWeightEdit').val(vehicle.netWeight);
			$('#powerEdit').val(vehicle.power);
			var regDate = vehicle.registrationDate.substr(0,10);
			$('#registrationDateEdit').val(regDate);
			$('#remarksEdit').val(vehicle.remarks);
			$('#ddlVehicleMakeEdit').val(vehicle.vehiclemakeid);		
			$('#ddlVehicleModelEdit').val(vehicle.vehiclemodelid);			
			$('#vehicleNumberEdit').val(vehicle.vehicleNumber);			
			$('#ddlVehicleStatusEdit').val(vehicle.vehiclestatusid);			
			$('#ddlVehicleTypeEdit').val(vehicle.vehicletypeid);	
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicle, status){
			var acDate = vehicle.acquisitionDate.substr(0,10);
			$('#acquisitionDateDetails').val(acDate);
			$('#descriptionDetails').val(vehicle.description);
			$('#ddlEmployeeDetails').val(vehicle.employeeid);
			$('#fuelCapacityDetails').val(vehicle.fuelCapacity);
			$('#idDetails').val(vehicle.id);
			$('#ddlLocationDetails').val(vehicle.locationid);
			$('#nameDetails').val(vehicle.name);
			$('#netWeightDetails').val(vehicle.netWeight);
			$('#powerDetails').val(vehicle.power);
			var regDate = vehicle.registrationDate.substr(0,10);
			$('#registrationDateDetails').val(regDate);
			$('#remarksDetails').val(vehicle.remarks);
			$('#ddlVehicleMakeDetails').val(vehicle.vehiclemakeid);		
			$('#ddlVehicleModelDetails').val(vehicle.vehiclemodelid);			
			$('#vehicleNumberDetails').val(vehicle.vehicleNumber);			
			$('#ddlVehicleStatusDetails').val(vehicle.vehiclestatusid);			
			$('#ddlVehicleTypeDetails').val(vehicle.vehicletypeid);
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();		
	});	
	
	$('.table #photoButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#photoModal #vehiclePhoto').attr('src', href);
		$('#photoModal').modal();		
	});	
});