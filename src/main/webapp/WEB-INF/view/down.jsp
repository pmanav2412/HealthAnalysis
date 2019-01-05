<!DOCTYPE html>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>Export a Table to PDF Template | PrepBootstrap</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />


    <script type="text/javascript" src="static/js/jquery-1.10.2.min.js"></script>
   
</head>
<body>

<div class="container">

<div class="page-header">
    <h1>Export a Table to PDF <small>Export an HTML TABLE to PDF</small></h1>
</div>

<!-- Export a Table to PDF - START -->


<div class="container">
    <button id="exportButton" class="btn btn-lg btn-danger clearfix"><span class="fa fa-file-pdf-o"></span> Export to PDF</button>

    <table id="exportTable" class="table table-hover">
        <thead>
            <tr>
                <th>Name</th>
                <th>Age</th>
                <th>Coin</th>
                <th>Comment</th>
            </tr>
        </thead>
        <tbody>
           <c:forEach var="r" items="${reports}">
								<tr>
								<td>${r.name}</td>
								<td>${r.age}</td>
								<td>${r.coin}</td>
								<td>${r.comment}</td>
							</tr>	
							</c:forEach>
        </tbody>
    </table>
</div>

<!-- you need to include the shieldui css and js assets in order for the components to work -->
<link rel="stylesheet" type="text/css" href="http://www.shieldui.com/shared/components/latest/css/light/all.min.css" />
<script type="text/javascript" src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
<script type="text/javascript" src="http://www.shieldui.com/shared/components/latest/js/jszip.min.js"></script>

<script type="text/javascript">
    jQuery(function ($) {
        $("#exportButton").click(function () {
            // parse the HTML table element having an id=exportTable
            var dataSource = shield.DataSource.create({
                data: "#exportTable",
                schema: {
                    type: "table",
                    fields: {
                        Name: { type: String },
                        Age: { type: Number },
                        Coin: { type: Number },
                        Comment: {type: String}
                    }
                }
            });

            // when parsing is done, export the data to PDF
            dataSource.read().then(function (data) {
                var pdf = new shield.exp.PDFDocument({
                    author: "PrepBootstrap",
                    created: new Date()
                });

                pdf.addPage("a4", "portrait");

                pdf.table(
                    50,
                    50,
                    data,
                    [
                        { field: "Name", title: "Name", width: 200 },
                        { field: "Age", title: "Age", width: 50 },
                        { field: "Coin", title: "Coin", width: 30 },
                        { field: "Comment", title: "Comment", width: 200 }
                    ],
                    {
                        margins: {
                            top: 50,
                            left: 50
                        }
                    }
                );

                pdf.saveAs({
                    fileName: "PrepBootstrapPDF"
                });
            });
        });
    });
</script>

<style>
    #exportButton {
        border-radius: 0;
    }
</style>

<!-- Export a Table to PDF - END -->

</div>

</body>
</html>