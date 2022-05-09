<script>
    $('.table-bordered tbody tr').ready(function(){
        $('tbody tr').click(function(){
            $('tr').removeClass();
            $(this).addClass('selected');
        });
    });
</script>