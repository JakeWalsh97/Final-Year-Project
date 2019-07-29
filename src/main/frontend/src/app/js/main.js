// jQuery(document).ready(function( $ ) {

// 		// Menu settings
// 		$('#menuToggle, .menu-close').on('click', function(){
// 			$('#menuToggle').toggleClass('active');
// 			$('body').toggleClass('body-push-toleft');
// 			$('#theMenu').toggleClass('menu-open');
// 		});

// 		// Smooth scroll for the menu and links with .scrollto classes
// 	  $('.smoothscroll').on('click', function(e) {
// 	    e.preventDefault();
// 	    if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
// 	      var target = $(this.hash);
// 	      if (target.length) {

// 	        $('html, body').animate({
// 	          scrollTop: target.offset().top
// 	        }, 1500, 'easeInOutExpo');
// 	      }
// 	    }
// 			$('body').toggleClass('body-push-toleft');
// 			$('#theMenu').toggleClass('menu-open');
// 	  });


// });

// const accountSid = 'AC65b27550e9e2917c52fd6d719d469d8f';
// const authToken = '44c026b5928bca97e4bd678785150207';
// const client = require('twilio')(accountSid, authToken);

// client.messages.create({
// 	from: '+19318054488',
// 	body: 'Twilio Shenanigans!',
// 	to: '+3530879592297'
// }).then(message => console.log(message.sid))
// .done();
