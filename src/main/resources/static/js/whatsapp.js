document.addEventListener('DOMContentLoaded', function() {

    const btnEnviarContato = document.getElementById('btnEnviarContato');
    const text = 'Olá! Vi seu portifólio e gostaria de conversar com você!'

    btnEnviarContato.addEventListener('click', function () {
        Swal.fire({
            title: 'Redirecionando para o WhatsApp...',
            text: 'Você será redirecionado em breve.',
            icon: 'info',
            showConfirmButton: false,
            timer: 1500
        });
        setTimeout(function () {

            window.location.href = 'https://api.whatsapp.com/send?phone=+5521995541157&text=' + text;
        }, 1500);
    });
});
