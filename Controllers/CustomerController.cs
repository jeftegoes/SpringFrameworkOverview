using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ExampleDotnetDatatablesPagination.Interfaces;
using ExampleDotnetDatatablesPagination.Models;
using Microsoft.AspNetCore.Mvc;

namespace ExampleDotnetDatatablesPagination.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class CustomerController : ControllerBase
    {
        private readonly ICustomerRepository _customerRepository;

        public CustomerController(ICustomerRepository customerRepository)
        {
            _customerRepository = customerRepository;
        }
        
        [HttpPost]
        public async Task<dynamic> GetCustomers([FromBody] DtParameters dtParameters)
        {
            var filterViewModel = new FilterViewModel()
            {
                OffsetValue = dtParameters.Start,
                PagingSize = dtParameters.Length,
                SearchText = dtParameters.Search.Value,
                SortOrder = dtParameters.Order[0].Dir,
                SortColumn = dtParameters.Order[0].Column
            };

            var customers = await _customerRepository.GetCustomers(filterViewModel);

            var filterTotalCount = customers.FirstOrDefault().FilterTotalCount;

            var test = new {
                draw = dtParameters.Draw,
                recordsTotal = filterTotalCount,
                recordsFiltered = filterTotalCount,
                data = customers  
            };

            return test;
        }
    }
}