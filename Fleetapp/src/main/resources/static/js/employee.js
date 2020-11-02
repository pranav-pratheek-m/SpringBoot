$('document').ready(function(){

 $('.table #editButton').on('click',function(event){
  event.preventDefault();
  var href = $(this).attr('href');
  
  $.get(href,function(employee,status){
    $('#idEdit').val(employee.id);
    $('#ddlTitleEdit').val(employee.title);
    $('#initialsEdit').val(employee.initials);
    $('#SSNEdit').val(employee.socialSecurityNumber);
    $('#firstnameEdit').val(employee.firstname);
    $('#lastnameEdit').val(employee.lastname);
    $('#othernameEdit').val(employee.othername);
    $('#ddlGenderEdit').val(employee.gender);
    $('#ddlNationalityEdit').val(employee.countryid);
    $('#addressEdit').val(employee.address);
    $('#dateOfBirthEdit').val(employee.dateOfBirth);
    $('#hireDateEdit').val(employee.hireDate);
    $('#ddlStateEdit').val(employee.stateid);
    $('#cityEdit').val(employee.city);
    $('#phoneEdit').val(employee.phone);
    $('#mobileEdit').val(employee.mobile);
    $('#ddlMaritalStatusEdit').val(employee.maritalStatus);
    $('#emailEdit').val(employee.email);
    $('#ddlJobTitleEdit').val(employee.jobtitleid);
    $('#ddlEmployeeTypeEdit').val(employee.employeetypeid);
    $('#fupImageEdit').val(employee.photo);
   });
  $('#editModal').modal();
 });

  $('.table #detailsButton').on('click',function(event){
  event.preventDefault();
  var href = $(this).attr('href');
  
  $.get(href,function(employee,status){
    $('#idDetails').val(employee.id);
    $('#ddlTitleDetails').val(employee.title);
    $('#initialsDetails').val(employee.initials);
    $('#SSNDetails').val(employee.socialSecurityNumber);
    $('#firstnameDetails').val(employee.firstname);
    $('#lastnameDetails').val(employee.lastname);
    $('#othernameDetails').val(employee.othername);
    $('#ddlGenderDetails').val(employee.gender);
    $('#ddlNationalityDetails').val(employee.countryid);
    $('#addressDetails').val(employee.address);
    $('#dateOfBirthDetails').val(employee.dateOfBirth);
    $('#hireDateDetails').val(employee.hireDate);
    $('#ddlStateDetails').val(employee.stateid);
    $('#cityDetails').val(employee.city);
    $('#phoneDetails').val(employee.phone);
    $('#mobileDetails').val(employee.mobile);
    $('#ddlMaritalStatusDetails').val(employee.maritalStatus);
    $('#emailDetails').val(employee.email);
    $('#ddlJobTitleDetails').val(employee.jobtitleid);
    $('#ddlEmployeeTypeDetails').val(employee.employeetypeid);
    $('#fupImageDetails').val(employee.photo);
   });
  $('#detailsModal').modal();
 });
 
 
  $('.table #deleteButton').on("click",function(event){
    event.preventDefault();
    var href = $(this).attr('href');
    $('#deleteModal #delRef').attr('href',href);
    $('#deleteModal').modal();
  });
  
  $('.table #photoButton').on("click",function(event){
    event.preventDefault();
    var href = $(this).attr('href');
    $('#photoModal #employeePhoto').attr('src',href);
    $('#photoModal').modal();
  });
  
});