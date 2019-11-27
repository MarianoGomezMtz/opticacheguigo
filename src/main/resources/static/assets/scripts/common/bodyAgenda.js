document.addEventListener('DOMContentLoaded', function() {
  var calendarEl = document.getElementById('calendar');

  var calendar = new FullCalendar.Calendar(calendarEl, {
     plugins: [ 'bootstrap', 'interaction', 'dayGrid', 'timeGrid', 'list' ],
    defaultView: 'dayGridMonth',
     navLinks: true,
     locale: 'es',
     timeZone: 'UTC',
    header: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
          },
    eventRender: function(info) {
      var tooltip = new Tooltip(info.el, {
        title: info.event.extendedProps.description,
        placement: 'top',
        trigger: 'hover',
        container: 'body'
      });
    },
       eventClick: function(info) {
              var eventObj = info.event;

              if (eventObj.url) {
                alert(
                  'Clicked ' + eventObj.title + '.\n' +
                  'Will open ' + eventObj.url + ' in a new tab'
                );

                window.open(eventObj.url);

                info.jsEvent.preventDefault(); // prevents browser from following link in current tab.
              } else {
                alert('Clicked ' + eventObj.title);
              }
            },
    events: [
      {
        title: 'All Day Event',
        description: 'description for All Day Event',
        start: '2019-06-01'
      },
      {
        title: 'Long Event',
        description: 'description for Long Event',
        start: '2019-06-07',
        end: '2019-06-10'
      },
      {
        groupId: '999',
        title: 'Repeating Event',
        description: 'description for Repeating Event',
        start: '2019-06-09T16:00:00'
      },
      {
        groupId: '999',
        title: 'Repeating Event',
        description: 'description for Repeating Event',
        start: '2019-06-16T16:00:00'
      },
      {
        title: 'Conference',
        description: 'description for Conference',
        start: '2019-06-11',
        end: '2019-06-13'
      },
      {
        title: 'Meeting',
        description: 'description for Meeting',
        start: '2019-06-12T10:30:00',
        end: '2019-06-12T12:30:00'
      },
      {
        title: 'Lunch',
        description: 'description for Lunch',
        start: '2019-06-12T12:00:00'
      },
      {
        title: 'Meeting',
        description: 'description for Meeting',
        start: '2019-06-12T14:30:00'
      },
      {
        title: 'Birthday Party',
        description: 'description for Birthday Party',
        start: '2019-06-13T07:00:00'
      },
      {
        title: 'Click for Google',
        description: 'description for Click for Google',
        url: 'http://google.com/',
        start: '2019-06-28'
      }
    ]
  });

  calendar.render();
});