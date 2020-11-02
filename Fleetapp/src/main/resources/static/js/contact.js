$('document').ready(function(){

 $('.table #editButton').on("click",function(event){
   event.preventDefault();
   var href = $(this).attr('href');
   
   $.get(href,function(contact,status){
    $("#txtIdEdit").val(contact.id);
    $("#txtFirstnameEdit").val(contact.firstname);
    $("#txtLastnameEdit").val(contact.lastname);
    $("#txtEmailEdit").val(contact.email);
    $("#txtMobileEdit").val(contact.mobile);
    $("#txtPhoneEdit").val(contact.phone);
    $("#txtRemarksEdit").val(contact.remarks);
   });
   $('#editModal').modal();
 });
 
 $('.table #detailsButton').on("click",function(event){
   event.preventDefault();
   var href = $(this).attr('href');
   
   $.get(href,function(contact,status){
    $("#idDetails").val(contact.id);
    $("#firstnameDetails").val(contact.firstname);
    $("#lastnameDetails").val(contact.lastname);
    $("#emailDetails").val(contact.email);
    $("#mobileDetails").val(contact.mobile);
    $("#phoneDetails").val(contact.phone);
    $("#remarksDetails").val(contact.remarks);
   });
   $('#detailsModal').modal();
 });
 
 $('.table #deleteButton').on("click",function(event){
   event.preventDefault();
   var href = $(this).attr('href',href);
   $("#deleteModal #delRef").attr('href',href);
   $('#deleteModal').modal();
 });
 

});