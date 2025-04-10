<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset='utf-8' />
  <script src='js/index.global.js'></script>
  <script>
    document.addEventListener('DOMContentLoaded', async function () {
        var calendarEl = document.getElementById('calendar');

        console.log('1')
        var events = [];
        // Ajax call

        console.log('2')
        let result = await fetch('eventList.do')
        let result2 = await result.json(); // [{title, start, end}}]
        console.log(result2);
        result2.forEach(item => {
          events.push({
            title: item.title,
            start: item.startDate,
            end: item.endDate
          })
        });

        console.log('3')
        //events = result; // json문자열 -> events 변수 할당

        var calendar = new FullCalendar.Calendar(calendarEl, {
          headerToolbar: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek,timeGridDay'
          },
          initialDate: '2025-01-01',
          navLinks: true, // can click day/week names to navigate views
          selectable: true,
          selectMirror: true,
          select: async function (arg) {
            console.log(arg);
            var title = prompt('Event Title:');
            if (title) {
              let allDay = arg.allDay; // 하루전체일정, 부분일정
              let start = allDay ? arg.startStr : arg.startStr.substring(0, 19);
              let end = allDay ? arg.endStr : arg.endStr.substring(0, 19);

              // let r1 = await fetch('addEvent.do?title='+title + '&startDate=' + start + '&endDate=' + end);
              let r1 = await fetch('addEvent.do', {
                method: 'post',
                headers: {
                  'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: 'title=' + title + '&startDate=' + start + '&endDate=' + end
              });
              let r2 = await r1.json();

              if (r2.retCode == 'OK') {
                //화면출력.
                calendar.addEvent({
                  title: title,
                  start: arg.start,
                  end: arg.end,
                  allDay: arg.allDay
                })
              } else
                alert('등록실패!');
            } // end of if
            calendar.unselect()
          },
          eventClick: function (arg) {
            if (confirm('Are you sure you want to delete this event?')) {
              let xhtp = fetch('removeEvent.do?title=' + arg.event.title + '&start=' + arg.event
                .start + '&end=' + arg.event.end);
              let result = xhtp.json();
              if (result.retCode == 'OK') {
                arg.event.remove();
              } else {
                alert('Transaction error!');
              }
            }
          },
          editable: true,
          dayMaxEvents: true, // allow "more" link when too many events

          events: events
        });
        calendar.render();

      } // end of function
    );
  </script>
  <style>
    body {
      margin: 40px 10px;
      padding: 0;
      font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
      font-size: 14px;
    }

    #calendar {
      max-width: 1100px;
      margin: 0 auto;
    }
  </style>
</head>

<body>
  <div id='calendar'></div>
</body>

</html>