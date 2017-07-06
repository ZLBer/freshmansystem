$(function(){
    H_sideinfoServer={};
    H_sideinfoServer.clickOpenServer = function () {
        $('.sideinfo-client-open').click(function(){
            $('.sideinfo-client').animate({
                left: '-60'
            },400);
            $('.sideinfo-client-content').animate({
                left: '0',
                opacity: 'show'
            }, 800 );
        });
        $('.sideinfo-client-close').click(function(){
            $('.sideinfo-client').animate({
                left: '0',
                opacity: 'show'
            },400);
            $('.sideinfo-client-content').animate({
                left: '-300',
                opacity: 'show'
            }, 800 );
        });
    };
    H_sideinfoServer.run= function () {
        this.clickOpenServer();
    };
    H_sideinfoServer.run();
});
