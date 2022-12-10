<script>
    $('.table-bordered tbody tr').each(function(i) {
        var number = i + 1;
        $(this).find('td:first').text(number + ${page - 1} * 10);
    });
</script>