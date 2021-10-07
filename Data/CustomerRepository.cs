using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;
using Dapper;
using ExampleDotnetDatatablesPagination.Interfaces;
using ExampleDotnetDatatablesPagination.Models;

namespace ExampleDotnetDatatablesPagination.Data
{
    public class CustomerRepository : ICustomerRepository
    {
        public async Task<List<Customer>> GetCustomers(FilterViewModel filterViewModel)
        {
            var param = new {
                p_sortColumn = filterViewModel.SortColumn,
                p_sortOrder = filterViewModel.SortOrder,
                p_offsetValue = filterViewModel.OffsetValue,
                p_pagingSize = filterViewModel.PagingSize,
                p_searchText = filterViewModel.SearchText
            };

            using (var connection = new SqlConnection("Server=HADES-PC; User Id=sa; Password=masterkey;Database=TestDatatables"))
            {
                var orderDetails = (await connection.QueryAsync<Customer>(@"EXEC stpGetCustomers 
                                                                            @p_sortColumn, 
                                                                            @p_sortOrder,
                                                                            @p_offsetValue,
                                                                            @p_pagingSize,
                                                                            @p_searchText", param)).ToList();
                return orderDetails;
            };
        }
    }
}