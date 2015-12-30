<!DOCTYPE html>
<html>
<head>
    <title>
        IT Company
    </title>
    <link rel="shortcut icon" href="/resources/images/favicon.ico"/>
    <link href="/resources/css/lib/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/resources/css/lib/font-awesome.css" rel="stylesheet" media="screen">
    <link href="/resources/css/main.css" rel="stylesheet" media="screen">
    <script type="text/javascript" src="/resources/js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="/resources/js/main.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        var $applicationRoot = "/";
        var $host = document.location.protocol + '//' + document.location.host;
        var $hostRoot = document.location.protocol + '//' + document.location.host + $applicationRoot;
    </script>
</head>

<body>
<div class="container">
    <div class="page-header">
        <h1>Contacts</h1>
    </div>
    <div class="col-lg-12">
        <table id="contacts-table" class="table table-striped">
            <thead>
            <tr>
                <td align="center"><b>Name</b></td>
                <td align="center"><b>Second Name</b></td>
                <td align="center"><b>Age</b></td>
                <td align="center"><b>Phone</b></td>
                <td align="center"><b></b></td>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>


    </div>
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-success pull-left" data-toggle="modal" data-target="#myModal">
        Add Contact
    </button>

    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Adding contact</h4>
                </div>
                <div class="col-lg-12">
                    <table id="add-contact" class="table table-striped">
                        <thead>
                        <tr>
                            <td align="center"><input type="text" class="form-control" id="name-field" placeholder="Name">
                            </td>
                            <td align="center"><input type="text" class="form-control" id="secondName-field" placeholder="Second Name">
                            </td>
                            <td align="center"><input type="text" class="form-control" id="age-field" placeholder="Age">
                            </td>
                            <td align="center"><input type="text" class="form-control" id="phone-field" placeholder="Phone">
                            </td>
                        </tr>
                        </thead>
                        <tbody></tbody>
                    </table>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button id="add-button" class="btn btn-success pull-right" data-dismiss="modal"
                            onclick="addContact()">Add
                    </button>
                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>