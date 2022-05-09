        $(function(){
         $('#cs_box_n').hide();
         $('#cs_box_q').hide();
         $('#cs_box_email').hide();
        })
        $(document).ready(function() {
     $('#cs_select_option').change(function() {
       var result = $('#cs_select_option option:selected').val();
       if (result == 'option1') {
         $('#cs_box_q').show();
       } else {
         $('#cs_box_q').hide();
       }
     }); 
   }); 
      $(document).ready(function() {
        $('#cs_select_option').change(function() {
       var result = $('#cs_select_option option:selected').val();
       if (result == 'option2') {
         $('#cs_box_n').show();
       } else {
         $('#cs_box_n').hide();
       }
     }); 
   }); 
   $(document).ready(function() {
        $('#cs_select_option').change(function() {
       var result = $('#cs_select_option option:selected').val();
       if (result == 'option3') {
         $('#cs_box_email').show();
       } else {
         $('#cs_box_email').hide();
       }
     }); 
   }); 
