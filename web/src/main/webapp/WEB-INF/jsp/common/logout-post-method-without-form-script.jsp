<%--@elvariable id="_csrf" type="org.springframework.security.web.csrf.CsrfToken"--%>
<script>
    $("#Logout").click(function(){
        const $form = $("<form>").attr({"action": "${pageContext.request.contextPath}/logout", "method": "post"})
            .append($("<input>").attr({"type": "hidden", "name": "${_csrf.parameterName}", "value": "${_csrf.token}"}));
        $("#Logout").append($form);
        $form.submit();
    });
</script>