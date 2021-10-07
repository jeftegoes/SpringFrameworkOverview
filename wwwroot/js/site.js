$(document).ready(function () {
  BindDataTable("/Customer",  [
                                { data: "customerName" },
                                { data: "contactName" },
                                { data: "address" },
                                { data: "city" },
                                { data: "postalCode" }
                              ]);
});

function BindDataTable(url, columns) {
  $("#tblDataTable").DataTable({
    processing: true,
    serverSide: true,
    paging: true,
    ajax: {
      url: url,
      type: "POST",
      contentType: "application/json",
      dataType: "json",
      data: function (data) {
        return JSON.stringify(data);
      },
    },
    columns: columns,
  });
}
