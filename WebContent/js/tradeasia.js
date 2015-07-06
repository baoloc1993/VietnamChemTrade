$(function(){
    
    // Enabling Popover Example 2 - JS (hidden content and title capturing)
    $("#popoverExampleTwo").popover({
        html : true, 
        content: function() {
          return $('#cartContent').html();
        },
        title: function() {
          return $('#cartTitle').html();
        },
         placement: "bottom"
    });

});


window.$zopim || (function (d, s) {
    var z = $zopim = function (c) {
        z._.push(c)
    }, $ = z.s =
            d.createElement(s), e = d.getElementsByTagName(s)[0];
    z.set = function (o) {
        z.set.
                _.push(o)
    };
    z._ = [];
    z.set._ = [];
    $.async = !0;
    $.setAttribute('charset', 'utf-8');
    $.src = '//v2.zopim.com/?1kUgCWtYUhiYkCh3M3I7o4tqy892pDcX';
    z.t = +new Date;
    $.
            type = 'text/javascript';
    e.parentNode.insertBefore($, e)
})(document, 'script');