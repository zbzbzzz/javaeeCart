/******************************

INDEX:

    s00 - Predefined Variables
    s01 - Nice Select Init
    s02 - Main Navigation Menu
    s03 - Image Background Settings
    s04 - Primary Slider Settings
    s05 - Elements Spacing & Classes
    s06 - Element Carousels
    s07 - Tooltips
    s08 - Product Gallery with Thumbnails
    s09 - Countdown Settings
    s10 - Testimonial Carousel
    s11 - Client Carousel
    s12 - Recent Post Widget Carousel
    s13 - Scroll to Top JS
    s14 - Price range Slider
    s15 - Interactive Behaviour
    s16 - Instagram Settings



******************************/

(function($) {

    "use strict";

    // Declaring main variable
    var ORORUS = {};


    /************************************************************
        s00 - Predefined Variables
    *************************************************************/

    var $window             = $(window),
        $document           = $(document),
        $niceSelect         = $(".nice-select"),
        $mainMenu           = $(".stellarnav"),
        $mainMenufl         = $(".floating-nav"),
        $pSlider            = $("#primary_slider"),
        $prodCarousel       = $(".product-carousel"),
        $galleryThumbs      = $(".gallery-with-thumbs"),
        $countDownTimer     = $(".countdown-timer"),
        $testimonial        = $(".testimonial-container"),
        $clients            = $(".client-carousel"),
        $recentPosts        = $(".recent-posts-widget"),
        $toTop              = $("#to_top"),
        $intelHeader        = $(".main-nav-area"),
        $footer             = $("#colophon"),
        $priceRange         = $("#price_slider"),
        $instagram          = $("#instagram_feed");


    // Check if element exists
    $.fn.elExists = function() {
        return this.length > 0;
    };


    /************************************************************
        s01 - Nice Select Init
    *************************************************************/
    ORORUS.niceInit = function() {
        $niceSelect.niceSelect();
    };


    /************************************************************
        s02 - Main Navigation Menu
    *************************************************************/

    ORORUS.mainNav = function() {
        $mainMenu.stellarNav({
            theme: 'plain',
            breakpoint: 991,
            openingSpeed: 300,
            closingDelay: 100
        });

        // Adding active class to nav menu depending on page
        var pageUrl = window.location.href.substr(window.location.href.lastIndexOf("/") + 1);
        $("#main_nav a").each(function() {
            if ($(this).attr("href") === pageUrl || $(this).attr("href") === '') {
                $(this).closest('li').addClass("active");
                $(this).parents('li').addClass('active');
            }
            else if (window.location.pathname === '/' || window.location.pathname === '/index.html') {
                $('#main_nav a[href="index.html"]').parent('li').addClass('active');
            }
        })
    };


    /************************************************************
        s03 - Image Background Settings
    *************************************************************/

    ORORUS.imageBgSettings = function() {
        $(".bg-img-wrapper").each(function() {
            var $this = $(this);
            var img = $this.find("img.visually-hidden").attr("src");

            $this.find(".image-placeholder").css({
                backgroundImage: "url(" + img + ")",
                backgroundSize: "cover",
                backgroundPosition: "center center"
            })
        });
    };


    /************************************************************
        s04 - Primary Slider Settings
    *************************************************************/

    ORORUS.primarySlider = function() {
        if ($pSlider.elExists()) {

            var interleaveOffset = 0.5;

            if(navigator.userAgent.toLowerCase().indexOf('firefox') > -1){
                 // Firefox-related activities
                 var interleaveOffset = 0;
            }

            var swiperOptions = {
                loop: true,
                speed: 1000,
                effect: (navigator.userAgent.toLowerCase().indexOf('firefox') > -1) ? 'fade' : 'slide', // Show fade effect instead of parallax slide in Firefox
                watchSlidesProgress: true,
                mousewheelControl: true,
                keyboardControl: true,

                autoplay: {
                    delay: 7000
                },

                navigation: {
                    nextEl: ".swiper-arrow.next.slide",
                    prevEl: ".swiper-arrow.prev.slide"
                },

                pagination: {
                    el: '.swiper-pagination',
                    clickable: true
                },

                // Giving slider a background parallax sliding effect
                on: {
                    progress: function() {
                        var swiper = this;
                        for (var i = 0; i < swiper.slides.length; i++) {
                            var slideProgress = swiper.slides[i].progress;
                            var innerOffset = swiper.width * interleaveOffset;
                            var innerTranslate = slideProgress * innerOffset;
                            swiper.slides[i].querySelector(".slide-inner").style.transform =
                                "translate3d(" + innerTranslate + "px, 0, 0)";
                        }
                    },
                    touchStart: function() {
                        var swiper = this;
                        for (var i = 0; i < swiper.slides.length; i++) {
                            swiper.slides[i].style.transition = "";
                        }
                    },
                    setTransition: function(speed) {
                        var swiper = this;
                        for (var i = 0; i < swiper.slides.length; i++) {
                            swiper.slides[i].style.transition = speed + "ms";
                            swiper.slides[i].querySelector(".slide-inner").style.transition =
                                speed + "ms";
                        }
                    }
                }
            };

            var swiper = new Swiper($pSlider, swiperOptions);
        }
    };


    /************************************************************
        s05 - Elements Spacing & Classes
    *************************************************************/

    ORORUS.ElementsSpacingClasses = function() {

        // Fixed Navigation Menu Height
        var headerHeight = $intelHeader[0].getBoundingClientRect().height;
        var headerTopHeight = $('header .header-area')[0].getBoundingClientRect().height;

        // Sticky header
        $window.on('scroll', function() {
            var height = $window.scrollTop();
            if (height < headerTopHeight) {
                $(".fixed-header-space").height(0);
                $intelHeader.removeClass("sticky");
            } else if (height > headerTopHeight + headerHeight) {
                $(".fixed-header-space").height(headerHeight);
                $intelHeader.addClass("sticky");
            }
        });

        // For Main Menu float over Primary Slider
        if ($mainMenufl.elExists()) {
            var navHeight = $mainMenufl[0].getBoundingClientRect().height;
            $pSlider.css("margin-top", -navHeight);
        }

        // Slider content dynamic height
        if ($pSlider.elExists()) {
            var sliderHeight = $pSlider[0].getBoundingClientRect().height;
            $("#primary_slider .slide-content").parent(this).css("height", sliderHeight);
        }

        // Equal height columns in slider section
        if ($window.width() > 991) {
            if ($(".top-promo-banners").elExists()) {
                var topBanners = $('.top-promo-banners')[0].getBoundingClientRect().height;
                $pSlider.height(topBanners);
            }
        }

        // Equal height columns in Google Map section
        if ($window.width() > 767) {
            if ($("#gmap").elExists()) {
                var formHeight = $(".contact-form-wrapper")[0].getBoundingClientRect().height;
                $('#gmap').css("height", formHeight);
            }
        }
    };


    /************************************************************
        s06 - Element Carousels
    *************************************************************/

    ORORUS.productCarousel = function() {

        var visibleSlides       = null;
        var visibleSlides_lg    = null;
        var visibleSlides_md    = null;
        var visibleSlides_sm    = null;
        var slideLoop           = null;
        var slideSpeed          = null;
        var slideSpace          = null;

        if ($prodCarousel.elExists()) {

            var swiperInstances = [];

            $prodCarousel.each(function(index, element) {

                var $this = $(this);

                // Fetching from data attributes
                var visibleSlides       = $this.attr("data-visible-slide") ? parseInt($this.attr("data-visible-slide")) : 5;
                var visibleSlides_lg    = $this.attr("data-visible-lg-slide") ? parseInt($this.attr("data-visible-lg-slide")) : 4;
                var visibleSlides_md    = $this.attr("data-visible-md-slide") ? parseInt($this.attr("data-visible-md-slide")) : 3;
                var visibleSlides_sm    = $this.attr("data-visible-sm-slide") ? parseInt($this.attr("data-visible-sm-slide")) : 2;
                var slideSpeed          = $this.attr("data-speed") ? parseInt($this.attr("data-speed")) : 1000;
                var slideLoop           = $this.attr("data-loop") === 'true' ? 1 : 0;
                var slideSpace          = $this.attr("data-space-between") ? parseInt($this.attr("data-space-between")) : 30;

                // Adding slider and slider-nav instances to use multiple times in a page
                $this.addClass("instance-" + index);
                $this.parent().find(".prev").addClass("prev-" + index);
                $this.parent().find(".next").addClass("next-" + index);

                swiperInstances[index] = new Swiper(".instance-" + index, {
                    slidesPerView: visibleSlides,
                    spaceBetween: slideSpace,
                    speed: slideSpeed,
                    loop: slideLoop,
                    autoplay: {
                        delay: 100000000
                    },

                    navigation: {
                        nextEl: '.swiper-arrow.next',
                        prevEl: '.swiper-arrow.prev'
                    },

                    pagination: {
                        el: '.pagination-' + index,
                        type: 'bullets',
                        clickable: true
                    },

                    // Responsive breakpoints
                    breakpoints: {
                        1199: {
                            slidesPerView: visibleSlides_lg
                        },
                        991: {
                            slidesPerView: visibleSlides_md
                        },
                        767: {
                            slidesPerView: visibleSlides_sm
                        },
                        479: {
                            slidesPerView: 1,
                            autoplay: {
                                delay: 5000
                            }
                        }
                    }
                });
            });
            
            // Updating the sliders
            setTimeout(function () {
                swiperInstances.forEach(function(slider) {
                    slider.update();
                })
            }, 50);

            // Updating the sliders in tab
            $('body').on('shown.bs.tab', 'a[data-toggle="tab"], a[data-toggle="pill"]', function (e) {
                swiperInstances.forEach(function(slider) {
                    slider.update();
                })
            });
        }
    };


    /************************************************************
        s07 - Tooltips
    *************************************************************/

    ORORUS.toolTips = function() {
        $('body').tooltip( {selector: '[data-toggle=tooltip]'} );
    };


    /************************************************************
        s08 - Product Gallery with Thumbnails
    *************************************************************/

    ORORUS.galleryWithThumb = function() {
        if ($galleryThumbs.elExists()) {

            // Params
            var mainSliderSelector = '.main-slider',
                navSliderSelector = '.nav-slider';

            // Main Slider
            var mainSliderOptions = {
                effect: 'fade',
                loop: true,
                speed:1000,
                loopAdditionalSlides: 10,
                watchSlidesProgress: true,
                observer: true,
                observeParents: true
            };
            var mainSlider = new Swiper(mainSliderSelector, mainSliderOptions);

            // Navigation Slider
            var navSliderOptions = {
                loop: true,
                loopAdditionalSlides: 10,
                speed:1000,
                slidesPerView: 3,
                centeredSlides: true,
                spaceBetween: 15,
                autoplay: {
                    delay: 100000000
                },
                touchRatio: 0.2,
                grabCursor: true,
                slideToClickedSlide: true,

                navigation: {
                    nextEl: '.swiper-arrow.next',
                    prevEl: '.swiper-arrow.prev'
                },

                // Responsive breakpoints
                breakpoints: {
                    479: {
                        autoplay: {
                            delay: 5000
                        }
                    }
                }
            };
            var navSlider = new Swiper(navSliderSelector, navSliderOptions);

            // Connecting the sliders
            mainSlider.controller.control = navSlider;
            navSlider.controller.control = mainSlider;

            // Updating slider in modal
            $('body').on('show.bs.modal', '#product_quick_view', function() {
                setTimeout(function() {
                    navSlider.update();
                    mainSlider.update();
                }, 500);
            });
        }
    };


    /************************************************************
        s09 - Countdown Settings
    *************************************************************/

    ORORUS.countDown = function() {
        if ($countDownTimer.elExists()) {

            var countInstances = [];
            $countDownTimer.each(function(index, element) {

                var $this = $(this);

                // Fetching from data attibutes
                var year    = $this.attr("data-countdown-year") ? $this.attr("data-countdown-year") : 2019;
                var month   = $this.attr("data-countdown-month") ? $this.attr("data-countdown-month") : 6;
                var day     = $this.attr("data-countdown-day") ? $this.attr("data-countdown-day") : 28;

                // Adding instances for multiple use
                $this.addClass("instance-0" + index);

                // Initializing the count down
                countInstances[index] = simplyCountdown(".instance-0" + index, {
                    year: year,
                    month: month,
                    day: day,
                    words: {                            // Words displayed into the countdown
                        days: 'day',
                        hours: 'hr',
                        minutes: 'min',
                        seconds: 'sec',
                        pluralLetter: 's'
                    },
                    plural: true,                       // Use plurals
                    inline: false,
                    enableUtc: false,
                    refresh: 1000,                      // Default refresh every 1s
                    sectionClass: 'countdown-section',  // Section css class
                    amountClass: 'countdown-amount',    // Amount css class
                    wordClass: 'countdown-word'         // Word css class
                });
            });
        }
    };


    /************************************************************
        s10 - Testimonial Carousel
    *************************************************************/

    ORORUS.testimonialCarousel = function() {
        if ($testimonial.elExists()) {
            var testimonial = new Swiper($testimonial, {
                loop: true,
                spaceBetween: 0,
                parallax: true,
                speed: 1000,
                autoplay: {
                    delay: 6000
                },

                pagination: {
                    el: '.swiper-pagination-testimonial',
                    clickable: true
                },

                navigation: {
                    nextEl: '.swiper-arrow.next.testimonial-slide',
                    prevEl: '.swiper-arrow.prev.testimonial-slide'
                }
            });
        }
    };


    /************************************************************
        s11 - Client Carousel
    *************************************************************/

    ORORUS.clientCarousel = function() {
        if ($clients.elExists()) {
            var client = new Swiper($clients, {
                loop: true,
                slidesPerView: 5,
                spaceBetween: 0,
                speed: 1000,
                centeredSlides: true,
                grabCursor: true,
                autoplay: {
                    delay: 5000
                },

                // Responsive breakpoints
                breakpoints: {
                    1199: {
                        slidesPerView: 4,
                        centeredSlides: false
                    },
                    991: {
                        slidesPerView: 4,
                        centeredSlides: false
                    },
                    767: {
                        slidesPerView: 3
                    },
                    575: {
                        slidesPerView: 3
                    },
                    479: {
                        slidesPerView: 2,
                        centeredSlides: false
                    }
                }
            })
        }
    };


    /************************************************************
        s12 - Recent Post Widget Carousel
    *************************************************************/

    ORORUS.recentPostsWidget = function() {
        if ($recentPosts.elExists()) {
            var postCarousel = new Swiper($recentPosts, {
                loop: true,
                slidesPerView: 1,
                spaceBetween: 10,
                speed: 1000,

                autoplay: {
                    delay: 5000
                },

                // Responsive breakpoints
                breakpoints: {
                    767: {
                        slidesPerView: 2,
                        centeredSlides: false
                    },
                    575: {
                        slidesPerView: 1
                    }
                }
            });
        }
    };


    /************************************************************
        s13 - Scroll to Top JS
    *************************************************************/

    ORORUS.scrollToTop = function() {
        $toTop.hide();
        $window.on('scroll', function() {
            if ($window.scrollTop() > 300) {
                $toTop.fadeIn();
            } else {
                $toTop.fadeOut();
            }
        });

        $toTop.on('click', function() {
            $("html,body").animate({
                scrollTop: 0
            }, 800)
        });
    };


    /************************************************************
        s14 - Price Range Slider
    *************************************************************/

    ORORUS.rangeSlider = function() {
        if ($priceRange.elExists()) {
            $priceRange.slider({
                range: true,
                min: 0,
                max: 145,
                values: [ 20, 440 ],
                slide: function( event, ui ) {
                    $( "#min_price" ).val('$' + ui.values[ 0 ] );
                    $( "#max_price" ).val('$' + ui.values[ 1 ] );
                }
            });
            $( "#min_price" ).val('$' + $priceRange.slider( "values", 0 ));
            $( "#max_price" ).val('$' + $priceRange.slider( "values", 1 ));
        }
    };

    /************************************************************
        s15 - Interactive Behaviour
    *************************************************************/

    ORORUS.interactiveBehaviour = function() {

        // Checkout Page Accordion Behaviour
        $( '#show_login' ).on('click', function() {
            $( '#checkout_login' ).slideToggle(300);
        });

        $( '#show_coupon' ).on('click', function() {
            $( '#checkout_coupon' ).slideToggle(300);
        });

        $("#different_shipping").on("change",function(){
            $(".ship-box-info").slideToggle(300);
        });

        $("#create_account").on("change",function(){
            $(".new-account-info").slideToggle(300);
        });
        

        // Header Custom dropdowns
        $("header .dropdown-toggle").on("click", function() {
            $(this).toggleClass('open').next('.dropdown-menu').toggleClass('open');
            $(this).parents().siblings().find('.dropdown-menu, .dropdown-toggle').removeClass('open');
        });

        // Closing the dropdown by clicking in the menu button or anywhere in the screen
        $('body').on('click', function (e) {
            var target = e.target;
            if (!$(target).is('.dropdown-toggle') && !$(target).parents().is('.dropdown-toggle')) {
                $('.dropdown-toggle, .dropdown-menu').removeClass('open');
            }
        });

        // Prevent closing dropdown upon clicking inside the dropdown
        $("header .dropdown-menu").on("click", function(e) {
            e.stopPropagation();
        });


        // Newsletter Popup
        setTimeout(function () {
            $('#newsletter_popup').css({
                "opacity": "1",
                "visibility": "visible"
            });

            // Closing the popup by clicking in the close button or anywhere in the screen
            $('body, .popup-close').on('click', function () {
                $("#newsletter_popup").css('visibility', 'hidden').animate({opacity: 0}, 100);
            });

            // Prevent closing popup upon clicking inside the popup
            $('#newsletter_popup .popup-container').on('click', function (e) {
                e.stopPropagation();
            });
        }, 2500);
    };


    /************************************************************
        s16 - Instagram Settings
    *************************************************************/

    ORORUS.instagramSettings = function() {
        if ($instagram.elExists()) {
            var feed = new Instafeed({
                get: 'user',
                userId: 6000547549,
                accessToken: '6000547549.1677ed0.cf5efae242d14b1e8ca149d38059cdee',
                target: 'instagram_feed',
                resolution: 'standard_resolution',
                limit: 9,
                template: '<figure><a href="{{image}}" data-size="640x640"><img src="{{image}}"/></a><figcaption class="visually-hidden"><span>{{caption}}</span></figcaption></figure>'
            });
            
            feed.run();
        }
    };



    // Window load functions
    $window.on('load', function() {
        ORORUS.primarySlider(),
        ORORUS.interactiveBehaviour();
        ORORUS.imageBgSettings();
    });

    // Document ready functions
    $document.on('ready', function() {
        ORORUS.niceInit(),
        ORORUS.mainNav(),
        ORORUS.productCarousel(),
        ORORUS.galleryWithThumb(),
        ORORUS.testimonialCarousel(),
        ORORUS.clientCarousel(),
        ORORUS.recentPostsWidget(),
        ORORUS.countDown(),        
        ORORUS.scrollToTop(),        
        ORORUS.toolTips(),
        ORORUS.rangeSlider(),
        ORORUS.instagramSettings();
    });

    // Window load and resize functions
    $window.on('load resize', function() {
        ORORUS.ElementsSpacingClasses();
    });

})(jQuery);