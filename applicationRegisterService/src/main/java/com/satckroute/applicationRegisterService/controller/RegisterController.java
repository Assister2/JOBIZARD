package com.satckroute.applicationRegisterService.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.satckroute.applicationRegisterService.domain.JobSeeker;
import com.satckroute.applicationRegisterService.domain.OrganizationDetails;
import com.satckroute.applicationRegisterService.domain.Recruiter;
import com.satckroute.applicationRegisterService.exception.*;
import com.satckroute.applicationRegisterService.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("api/v1")
public class RegisterController
{
    private RegisterService registerService;
    private ResponseEntity responseEntity;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }


//---------------------------------------------------------------------------------------------------------------------
//not needed
//    @PostMapping("/jobSeeker")
//    public ResponseEntity<?> addJobSeekerImage(@RequestParam("jobSeeker") String jobSeeker, @RequestParam("file") MultipartFile file) throws JobSeekerImageAlreadyExistException , IOException
//    {
//        try
//        {
//            JobSeeker jobSeeker1 = new ObjectMapper().readValue(jobSeeker, JobSeeker.class);
//            System.out.println("controller");
//            System.out.println(jobSeeker1);
//            registerService.saveJobSeekerImage(jobSeeker1, file);
//            ResponseEntity responseEntity = new ResponseEntity(registerService.saveJobSeekerImage(jobSeeker1, file), HttpStatus.CREATED);
//        }
//        catch (JobSeekerImageAlreadyExistException jobSeekerImageAlreadyExistException)
//        {
//            throw new JobSeekerImageAlreadyExistException();
//        }
//        catch (Exception exception)
//        {
//            System.out.println(exception);
//            responseEntity = new ResponseEntity<>("Try after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return responseEntity;
//    }

//---------------------------------------------------------------------------------------------------------------------

    // with images part
//    @PostMapping("/jobSeeker")
//    public ResponseEntity<?> addJobSeekerImage( @RequestParam("jobSeeker") String jobSeeker, @RequestParam("file") MultipartFile file) throws JobSeekerImageAlreadyExistException , IOException
//    {
//        JobSeeker jobSeeker1 = new ObjectMapper().readValue(jobSeeker,JobSeeker.class);
//        ResponseEntity responseEntity = new ResponseEntity(registerService.saveJobSeekerImage(jobSeeker1,file),HttpStatus.CREATED);
//
////        catch (JobSeekerImageAlreadyExistException jobSeekerImageAlreadyExistException)
////        {
////            throw new JobSeekerImageAlreadyExistException();
////        }
////        catch (Exception exception)
////        {
////            responseEntity = new ResponseEntity<>("Try after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
////        }
//        return responseEntity;
//    }

////---------------------------------------------------------------------------------------------------------------------

//    @PostMapping("/recruiter")
//    public ResponseEntity<?> addRecruiterImage(@RequestParam("recruiter") String recruiter, @RequestParam("file") MultipartFile file) throws RecruiterImageAlreadyExistException , IOException
//    {
//        Recruiter recruiter1 = new ObjectMapper().readValue(recruiter,Recruiter.class);
//        ResponseEntity responseEntity = new ResponseEntity(registerService.saveRecruiterImage(recruiter1,file),HttpStatus.CREATED);
//
//        return responseEntity;
//    }
////---------------------------------------------------------------------------------------------------------------------
//
//    @PostMapping("/organizationDetails")
//    public ResponseEntity<?> addOrganizationDetailsImage(@RequestParam("organizationDetails") String organizationDetails, @RequestParam("file") MultipartFile file) throws OrganizationDetailsAlreadyExistException , IOException
//    {
//        OrganizationDetails organizationDetails1 = new ObjectMapper().readValue(organizationDetails,OrganizationDetails.class);
//        ResponseEntity responseEntity = new ResponseEntity(registerService.saveOrganizationDetails(organizationDetails1,file),HttpStatus.CREATED);
//
//        return responseEntity;
//    }


//---------------------------------------------------------------------------------------------------------------------

    @PostMapping("/registerJobSeeker")
    public ResponseEntity<?> registerNewJobSeeker(@RequestBody JobSeeker jobSeeker) throws JobSeekerAlreadyExistException {
        try {
            return new ResponseEntity<>(registerService.registerNewJobSeeker(jobSeeker), HttpStatus.CREATED);
        } catch (JobSeekerAlreadyExistException jobSeekerAlreadyExistException) {
            throw new JobSeekerAlreadyExistException();
        } catch (Exception exception) {
            return new ResponseEntity<>("Try after some time.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//---------------------------------------------------------------------------------------------------------------------

    @PostMapping("/registerRecruiter")
    public ResponseEntity<?> registerNewRecruiter(@RequestBody Recruiter recruiter) throws RecruiterAlreadyExistException {
        try {
            return new ResponseEntity<>(registerService.registerNewRecruiter(recruiter), HttpStatus.CREATED);
        } catch (RecruiterAlreadyExistException recruiterAlreadyExistException) {
            throw new RecruiterAlreadyExistException();
//        } catch (Exception exception) {
//            return new ResponseEntity<>("Try after some time.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//---------------------------------------------------------------------------------------------------------------------

    @PostMapping("/saveOrganizationDetails")
    public ResponseEntity<?> registerOrganizationDetails(@RequestBody OrganizationDetails organizationDetails) throws OrganizationDetailsAlreadyExistException
    {
        try {
            return new ResponseEntity<>(registerService.saveOrganizationDetails(organizationDetails), HttpStatus.CREATED);
        } catch (OrganizationDetailsAlreadyExistException organizationDetailsAlreadyExistException) {
            throw new OrganizationDetailsAlreadyExistException();
        } catch (Exception exception) {
            return new ResponseEntity<>("Try after some time.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//---------------------------------------------------------------------------------------------------------------------

    @GetMapping("/getALlJobSeeker")
    public ResponseEntity<?> getAllJobSeekerDetails() {
        try {
            return new ResponseEntity<>(registerService.getAllJobSeeker(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>("Try after some time.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//---------------------------------------------------------------------------------------------------------------------

    @GetMapping("/getAllRecruiter")
    public ResponseEntity<?> getAllRecruiter() {
        try {
            return new ResponseEntity<>(registerService.getAllRecruiter(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>("Try after some time.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//---------------------------------------------------------------------------------------------------------------------

    @GetMapping("/getAllOrganization")
    public ResponseEntity<?> getAllOrganization() {
        try {
            return new ResponseEntity<>(registerService.getAllOrganization(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>("Try after some time.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//---------------------------------------------------------------------------------------------------------------------

    @GetMapping("/jobSeeker/getUserByFirstName/{firstName}")
    public ResponseEntity<?> getJobSeekerByFirstName(@PathVariable String firstName) throws JobSeekerNotFoundException {
        try {
            return new ResponseEntity<>(registerService.getAllJobSeekerByFirstName(firstName), HttpStatus.OK);
        } catch (JobSeekerNotFoundException jobSeekerNotFoundException) {
            throw new JobSeekerNotFoundException();
        } catch (Exception exception) {
            return new ResponseEntity<>("Try after some time.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//---------------------------------------------------------------------------------------------------------------------

    @GetMapping("/recruiter/getUserByFirstName/{firstName}")
    public ResponseEntity<?> getAllRecruiterByFirstName(@PathVariable String firstName) throws RecruiterNotFoundException {
        try {
            return new ResponseEntity<>(registerService.getAllRecruiterByFirstName(firstName), HttpStatus.OK);
        } catch (RecruiterNotFoundException recruiterNotFoundException) {
            throw new RecruiterNotFoundException();
        } catch (Exception exception) {
            return new ResponseEntity<>("Try after some time.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//---------------------------------------------------------------------------------------------------------------------

    @GetMapping("/organizationDetails/getOrganizationDetailsName/{organizationName}")
    public ResponseEntity<?> getAllOrganizationDetailsByOrganizationName(@PathVariable String organizationName) throws OrganizationDetailsNotFoundException
    {
        try {
            return new ResponseEntity<>(registerService.getAllOrganizationDetailsByOrganizationName(organizationName), HttpStatus.OK);
        }
        catch (OrganizationDetailsNotFoundException organizationDetailsNotFoundException)
        {
            throw new OrganizationDetailsNotFoundException();
        } catch (Exception exception) {
            return new ResponseEntity<>("Try after some time.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//---------------------------------------------------------------------------------------------------------------------

    @PutMapping("/jobSeeker/{emailId}")
    public ResponseEntity<?> updateJobSeekerDetails(@RequestBody JobSeeker jobSeeker, @PathVariable String emailId) throws JobSeekerNotFoundException {
        try {
            return new ResponseEntity<>(registerService.updateJobSeekerDetails(jobSeeker, emailId), HttpStatus.OK);
        } catch (JobSeekerNotFoundException e) {
            throw new JobSeekerNotFoundException();
        } catch (Exception exception) {
            return new ResponseEntity<>("Try after some time.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//---------------------------------------------------------------------------------------------------------------------

    @PutMapping("/jobSeeker1/{emailId}")
    public ResponseEntity<?> updateJobSeekerDetail(@RequestParam("jobSeeker1") String jobSeeker, @PathVariable String emailId , @RequestParam("file") MultipartFile file) throws JobSeekerNotFoundException, IOException
    {
//        return responseEntity;
        try
        {
            log.debug("RegisterController - updateJobSeekerDetail");
            JobSeeker jobSeeker1 = new ObjectMapper().readValue(jobSeeker,JobSeeker.class);
            //
            ResponseEntity responseEntity = new ResponseEntity(registerService.updateJobSeekerDetail(jobSeeker1,emailId,file),HttpStatus.CREATED);
            return new ResponseEntity<>(registerService.updateJobSeekerDetail(jobSeeker1, emailId,file), HttpStatus.OK);
        }
        catch (JobSeekerNotFoundException jobSeekerNotFoundException)
        {
            log.error("RegisterController - updateJobSeekerDetail"+jobSeekerNotFoundException);
            throw new JobSeekerNotFoundException();
        }
        catch (Exception exception)
        {
            log.error("RegisterController - updateJobSeekerDetail"+exception);
            return new ResponseEntity<>("Try after some time.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//---------------------------------------------------------------------------------------------------------------------

    @PutMapping("/recruiter/{emailId}")
    public ResponseEntity<?> updateRecruiterDetails(@RequestBody Recruiter recruiter, @PathVariable String emailId) throws RecruiterNotFoundException
    {
        try
        {
            return new ResponseEntity<>(registerService.updateRecruiterDetails(recruiter, emailId), HttpStatus.OK);
        }
        catch (RecruiterNotFoundException recruiterNotFoundException)
        {
            throw new RecruiterNotFoundException();
        }
        catch (Exception exception)
        {
            return new ResponseEntity<>("Try after some time.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//---------------------------------------------------------------------------------------------------------------------

    @PutMapping("/organization/{emailId}")
    public ResponseEntity<?> updateOrganizationDetails(@RequestBody OrganizationDetails organizationDetails, @PathVariable String emailId) throws OrganizationDetailsNotFoundException
    {
        try
        {
            return new ResponseEntity<>(registerService.updateOrganizationDetails(organizationDetails, emailId), HttpStatus.OK);
        }
        catch (OrganizationDetailsNotFoundException organizationDetailsNotFoundException)
        {
            throw new OrganizationDetailsNotFoundException();
        }
        catch (Exception exception)
        {
            return new ResponseEntity<>("Try after some time.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//---------------------------------------------------------------------------------------------------------------------

    @DeleteMapping("/jobSeeker/{emailId}")
    public ResponseEntity<?> deleteJobSeekerDetails (@PathVariable String emailId) throws JobSeekerNotFoundException
    {
        try {
            return new ResponseEntity<>(registerService.deleteJobSeekerDetails(emailId),HttpStatus.OK);
        }
        catch (JobSeekerNotFoundException jobSeekerNotFoundException)
        {
            throw new JobSeekerNotFoundException();
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("Try after some time.",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//---------------------------------------------------------------------------------------------------------------------

    @DeleteMapping("/recruiter/{emailId}")
    public ResponseEntity<?> deleteRecruiterDetails (@PathVariable String emailId) throws RecruiterNotFoundException
    {
        try {
            return new ResponseEntity<>(registerService.deleteRecruiterDetails(emailId),HttpStatus.OK);
        }
        catch (RecruiterNotFoundException recruiterNotFoundException)
        {
            throw new RecruiterNotFoundException();
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("Try after some time.",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//---------------------------------------------------------------------------------------------------------------------

    @DeleteMapping("/organizationDetails/{emailId}")
    public ResponseEntity<?> deleteOrganizationDetails (@PathVariable String emailId) throws OrganizationDetailsNotFoundException
    {
        try {
            return new ResponseEntity<>(registerService.deleteOrganizationDetails(emailId),HttpStatus.OK);
        }
        catch (OrganizationDetailsNotFoundException organizationDetailsNotFoundException)
        {
            throw new OrganizationDetailsNotFoundException();
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("Try after some time.",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //RecruiterLanding..................................................................................
    @GetMapping("/recruiterProfile/{emailId}")
    public ResponseEntity<?> getRecruiterProfile(@PathVariable String emailId) throws RecruiterNotFoundException {
        try {
            return new ResponseEntity<>(registerService.getRecruiterProfile(emailId), HttpStatus.OK);
        } catch (RecruiterNotFoundException recruiterNotFoundException) {
            throw new RecruiterNotFoundException();
        } catch (Exception exception) {
            return new ResponseEntity<>("Try after some time.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/jobSeekers")
    public ResponseEntity<?> getAllJobSeekers() throws JobSeekerNotFoundException {
        try {
            return new ResponseEntity<>(registerService.getAllJobSeekers(), HttpStatus.OK);
        } catch (JobSeekerNotFoundException jobSeekerNotFoundException) {
            throw new JobSeekerNotFoundException();
        } catch (Exception exception) {
            return new ResponseEntity<>("Try after some time.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/skillSet/{emailId}")
    public ResponseEntity<?> getSkillSet(@PathVariable String emailId) throws JobSeekerNotFoundException {
        try {
            return new ResponseEntity<>(registerService.getSkillSet(emailId), HttpStatus.OK);
        } catch (JobSeekerNotFoundException jobSeekerNotFoundException) {
            throw new JobSeekerNotFoundException();
        } catch (Exception exception){
            return new ResponseEntity<>("Try after some time.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}