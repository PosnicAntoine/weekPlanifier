package taa.weekPlanifier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import taa.weekPlanifier.entities.dto.ActivityDTO;
import taa.weekPlanifier.services.facade.ActivityService;

@CrossOrigin
@RequestMapping("/activity")
@Controller
public class ActivityController {
  // Private fields
  @Autowired
  private ActivityService activityService;

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
   * POST /create  --> Create a new activity and save it in the database.
   */
  //Done on front
  @RequestMapping(value= "/create", method = RequestMethod.POST)
  @ResponseBody
  public String create(@RequestBody ActivityDTO activity) {
	  return activityService.create(activity);	
  }

  /**
   * POST /update  --> Update the activity in the 
   * database.
   */
  //Done on front
  @RequestMapping(value= "/update", method = RequestMethod.POST)
  @ResponseBody
  public String updateActivity(@RequestParam("id") Long id,@RequestBody ActivityDTO activity) {
      return activityService.update(id, activity);
  }
  

  /**
   * POST /addAddress  --> add the address passed by id in activity
   * 
   */
  //TODO on front
  @RequestMapping(value= "/addAddress", method = RequestMethod.POST)
  @ResponseBody
  public String updateUser(@RequestParam("id") Long id,@RequestParam("idAddress") Long idAddress) {
      return activityService.addAddress(id, idAddress);
  }
  
  /**
   * DELETE /delete  --> Delete the activity having the passed id.
   */
  //Done on front
  @RequestMapping(value= "/delete", method = RequestMethod.DELETE)
  @ResponseBody
  public String delete(@RequestParam("id") long id) {
	  return activityService.delete(id);
  }
 
  /**
   * GET /getActivity  --> Get the activity of the passed id.
   */
  //Done on front
  @RequestMapping(value= "/getActivity", method = RequestMethod.GET)
  @ResponseBody
  public ActivityDTO getActivity(@RequestParam("id") long id) {
	  return activityService.getActivity(id);
  }
  

  /**
   * GET /getAllActivity  --> Get all of the activities.
   */
  //Done on front
  @RequestMapping(value= "/getAllActivity", method = RequestMethod.GET)
  @ResponseBody
  public java.util.List<ActivityDTO> getAllActivity() {
	  return activityService.getAllActivity();
  }
}
