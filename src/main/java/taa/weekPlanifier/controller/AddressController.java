package taa.weekPlanifier.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import taa.weekPlanifier.entities.dto.AddressDTO;
import taa.weekPlanifier.services.facade.AddressService;

@CrossOrigin
@RequestMapping("/address")
@Controller
public class AddressController {
  // Private fields
  @Autowired
  private AddressService addressService;

  /**
   * GET /hello  --> return hello
   */
  //Done on front
  @RequestMapping(value= "/hello", method = RequestMethod.GET)
  @ResponseBody
  public String hello() {
    return "Hello";
  }

  /**
   * POST /create  --> Create a new address and save it in the database.
   */
  //Done on front
  @RequestMapping(value= "/create", method = RequestMethod.POST)
  @ResponseBody
  public String create(@RequestBody AddressDTO address) {
	  return addressService.create(address);	
  }

  /**
   * POST /update  --> Update the address in the 
   * database.
   */
  //Done on front
  @RequestMapping(value= "/update", method = RequestMethod.POST)
  @ResponseBody
  public String updateAddress(@RequestParam("id") Long id,@RequestBody AddressDTO address) {
      return addressService.update(id, address);
  }
  
  /**
   * DELETE /delete  --> Delete the address having the passed id.
   */
  //Done on front
  @RequestMapping(value= "/delete", method = RequestMethod.DELETE)
  @ResponseBody
  public String delete(@RequestParam("id") long id) {
	  return addressService.delete(id);
  }
  
  /**
   * GET /getAddress  --> Get the address of the passed id.
   */
  //Done on front
  @RequestMapping(value= "/getAddress", method = RequestMethod.GET)
  @ResponseBody
  public AddressDTO getAddress(@RequestParam("id") long id) {
	  return addressService.getAddress(id);
  }
  

  /**
   * GET /getAllAddress  --> Get all of the addresss.
   */
  //Done on front
  @RequestMapping(value= "/getAllAddress", method = RequestMethod.GET)
  @ResponseBody
  public java.util.List<AddressDTO> getAllAddress() {
	  return addressService.getAllAddress();
  }
}
