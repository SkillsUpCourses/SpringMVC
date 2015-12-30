$(document).ready(function () {

    $.ajax({
        url: $hostRoot + "contact/",
        type: 'get',
        success: function (data) {
            $("#animals-pre-loader").remove();
            var contactRows = "";
            for (var i = 0; i < data.length; i++) {
                var contact = data[i];
                contactRows += "<tr id= \"" + contact.id + "\">" +
                    "<td align=\"center\">" + safeNull(contact.name) + "</td>" +
                    "<td align=\"center\">" + safeNull(contact.secondName) + "</td>" +
                    "<td align=\"center\">" + safeNull(contact.age) + "</td>" +
                    "<td align=\"center\">" + safeNull(contact.phone) + "</td>" +
                    "<td align=\"center\">" + "<i class=\"fa fa-trash\" id=\" \" onclick=\"myClick(" + contact.id + ")\"></i>" + "</td>" +
                    "</tr>";
            }
            $("#contacts-table tbody").html(contactRows);
        },
        error: function (error) {
            console.log(error)
        }

    });


});
var safeNull = function (value) {
    return value ? value : "-";
}
function myClick(id) {
    $.ajax({
        url: $hostRoot + "contact/delete/" + id,
        type: 'get',
        success: function (data) {
            deleteRow(id)
        },
        error: function (error) {
            console.log(error)
        }
    });
}
function deleteRow(rowid) {
    var row = document.getElementById(rowid);

    $(row).closest('tr')
        .children('td')
        .animate({ padding: 0 })
        .wrapInner('<div />')
        .children()
        .slideUp(function () {
            $(this).closest('tr').remove();
        });
}

function addContact() {
    if (document.getElementById("name-field").value == "") {
        alert("Please, set NAME of new contact")
    } else if (document.getElementById("secondName-field").value == "") {
        alert("Please, set Second Name of new contact")
    }else if (document.getElementById("age-field").value == "") {
        alert("Please, set AGE of new contact")
    } else if (document.getElementById("phone-field").value == "") {
        alert("Please, set Phone of new contact")
    } else {
        var contact = {name: document.getElementById("name-field").value,secondName: document.getElementById("secondName-field").value, age: document.getElementById("age-field").value, phone: document.getElementById("phone-field").value
        };

        var json = JSON.stringify(contact);
        $.ajax({
            url: $hostRoot + "contact/add",
            type: 'POST',
            data: json,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                var contactRows = "";
                for (var i = 0; i < data.length; i++) {
                    var contact = data[i];
                    contactRows += "<tr id= \"" + contact.id + "\">" +
                        "<td align=\"center\">" + safeNull(contact.name) + "</td>" +
                        "<td align=\"center\">" + safeNull(contact.secondName) + "</td>" +
                        "<td align=\"center\">" + safeNull(contact.age) + "</td>" +
                        "<td align=\"center\">" + safeNull(contact.phone) + "</td>" +
                        "<td align=\"center\">" + "<i class=\"fa fa-trash\" id=\" \"onclick=\"myClick(" + contact.id + ")\"></i>" + "</td>" +
                        "</tr>";
                }
                $("#contacts-table tbody").html(contactRows);

            },
            error: function (error) {
                console.log(error)
            }
        });
        document.getElementById("name-field").value = ""
        document.getElementById("secondName-field").value = ""
        document.getElementById("age-field").value = ""
        document.getElementById("phone-field").value = ""

    }
}

$(function() {

    $('#login-form-link').click(function(e) {
        $("#login-form").delay(100).fadeIn(100);
        $("#register-form").fadeOut(100);
        $('#register-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
    $('#register-form-link').click(function(e) {
        $("#register-form").delay(100).fadeIn(100);
        $("#login-form").fadeOut(100);
        $('#login-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });

});

