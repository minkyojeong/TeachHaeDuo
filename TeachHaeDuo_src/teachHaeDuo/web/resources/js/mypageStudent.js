$(function(){
            var check = $("input[type='checkbox']");
                check.click(function(){
                    $(".ms_toggle_p").toggle();
            });
            $("#ms_text_div1").mouseover(function(){
                $("#ms_arrow_active1").show();
                $("#ms_arrow1").hide();
            });
            $("#ms_text_div1").mouseout(function(){
                $("#ms_arrow_active1").hide();
                $("#ms_arrow1").show();
            });
            $("#ms_text_div2").mouseover(function(){
                $("#ms_arrow_active2").show();
                $("#ms_arrow2").hide();
            });
            $("#ms_text_div2").mouseout(function(){
                $("#ms_arrow_active2").hide();
                $("#ms_arrow2").show();
            });
            $("#ms_text_div3").mouseover(function(){
                $("#ms_arrow_active3").show();
                $("#ms_arrow3").hide();
            });
            $("#ms_text_div3").mouseout(function(){
                $("#ms_arrow_active3").hide();
                $("#ms_arrow3").show();
            });
         
         
        /* modal js */
          $(".ms_charge_btn").click(function(){
                $("#ms_pencilcharge_modal").show();
            });

            $(".ms_pencilcharge_modal_close").click(function(){
                $("#ms_pencilcharge_modal").hide();
            });

            ms_pencilcharge_modal.addEventListener("click", e => {
                const evTarget = e.target
                if(evTarget.classList.contains("ms_pencilcharge_modal_overlay")) {
                    $("#ms_pencilcharge_modal").hide();
                }
            })

            var pencilwon = 0;
            $("#ms_won").text(pencilwon);

            $("#ms_btn1").click(function(){
                if(pencilwon > 0){
                    pencilwon -= 10000
                    $("#won").val(pencilwon);
                }
            });
            $("#ms_btn2").click(function(){
               pencilwon += 10000
               $("#won").val(pencilwon);
            });
            $("#ms_btn3").click(function(){
               pencilwon += 30000
               $("#won").val(pencilwon);
            });
            $("#ms_btn4").click(function(){
               pencilwon += 50000
               $("#won").val(pencilwon);
            });
            $("#ms_btn5").click(function(){
               pencilwon += 100000
               $("#won").val(pencilwon);
            });

            $("#reset").click(function(){
                pencilwon = 0;
                $("#won").val(pencilwon);
            });

            $("#ms_charge").click(function(){
                if(pencilwon > 0){
                    var frm = document.ms_charge_frm;
                    frm.action = "pencilCharge.do";
                    frm.method = "post"
                    frm.submit();
                } else{
                    alert("충전 금액은 0원 초과로 입력해주세요");
                }
            });
         
         
        });