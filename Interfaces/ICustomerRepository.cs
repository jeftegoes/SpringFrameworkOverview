using System.Collections.Generic;
using System.Threading.Tasks;
using ExampleDotnetDatatablesPagination.Models;

namespace ExampleDotnetDatatablesPagination.Interfaces
{
    public interface ICustomerRepository
    {
         Task<List<Customer>> GetCustomers(FilterViewModel filterViewModel);
    }
}