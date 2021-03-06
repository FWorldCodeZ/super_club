package com.fiveofteam.super_club.controller;

import com.fiveofteam.super_club.pojo.Activity;
import com.fiveofteam.super_club.service.ActivityService;
import com.fiveofteam.super_club.tools.CommonStringTool;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping(value = "/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;
    private JsonResult jsonResult;

    /**
     * 创建活动
     * @param activity
     * @return
     */
    @RequestMapping(value = "/insertActivity", method = RequestMethod.POST)
    public JsonResult insertActivity(Activity activity,String organizerName,String activityCateId) {
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        if (null == activity){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，传递数据不能为空！");
            return jsonResult;
        }
        if (null == activity.getActivityClubId() || "".equals(activity.getActivityClubId().trim())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，社团ID不能为空！");
            return jsonResult;
        }
        if (null == activity.getActivityTitle() || "".equals(activity.getActivityTitle().trim())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动标题名不能为空！");
            return jsonResult;
        }
        if (null == activity.getActivityStartTime() || "".equals(activity.getActivityStartTime())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动开始时间不能为空！");
            return jsonResult;
        }
        if (null == activity.getActivityEndTime() || "".equals(activity.getActivityEndTime())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动结束时间不能为空！");
            return jsonResult;
        }
        if (activity.getActivityStartTime().after(activity.getActivityEndTime())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动时间格式不正确！");
            return jsonResult;
        }
        if (null == activity.getActivityPlace() || "".equals(activity.getActivityPlace().trim())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动举办地点不能为空！");
            return jsonResult;
        }
        if (null == activity.getActivityContent() || "".equals(activity.getActivityContent().trim())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动内容不能为空！");
            return jsonResult;
        }
        if (null == organizerName || "".equals(organizerName.trim())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "活动组织者不能为空！");
            return jsonResult;
        }
        try {
            jsonResult = activityService.insertActivity(activity,organizerName,activityCateId);
        } catch (Exception e) {
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，系统错误！");
        }
        return jsonResult;
    }

    /**
     * 更新活动
     * @param activity
     * @return
     */
    @RequestMapping(value = "/updateActivity", method = RequestMethod.POST)
    public JsonResult updateActivity(Activity activity,String organizerName,String activityCateId) {
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        if (null == activity){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，传递数据不能为空！");
            return jsonResult;
        }
        if (null == activity.getActivityTitle() || "".equals(activity.getActivityTitle().trim())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动标题名不能为空！");
            return jsonResult;
        }
        if (null == activity.getActivityStartTime() || "".equals(activity.getActivityStartTime())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动开始时间不能为空！");
            return jsonResult;
        }
        if (null == activity.getActivityEndTime() || "".equals(activity.getActivityEndTime())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动结束时间不能为空！");
            return jsonResult;
        }
        if (activity.getActivityStartTime().after(activity.getActivityEndTime())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动时间格式不正确！");
            return jsonResult;
        }
        if (null == activity.getActivityPlace() || "".equals(activity.getActivityPlace().trim())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动举办地点不能为空！");
            return jsonResult;
        }
        if (null == activity.getActivityContent() || "".equals(activity.getActivityContent().trim())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动内容不能为空！");
            return jsonResult;
        }
        if (null == organizerName || "".equals(organizerName.trim())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "活动组织者不能为空！");
            return jsonResult;
        }
        try {
            jsonResult = activityService.updateActivity(activity,organizerName,activityCateId);
        } catch (Exception e) {
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，系统错误！");
        }
        return jsonResult;
    }

    /**
     * 获取活动列表
     */
    @RequestMapping(value = "/selectList" ,method = RequestMethod.GET)
    public JsonResult selectActivityList(String activityClubId) {
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        if (null == activityClubId || "".equals(activityClubId.trim())){
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + "，社团ID不能为空！");
            return jsonResult;
        }
        try {
            jsonResult = activityService.selectList(activityClubId);
        } catch (Exception e) {
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + "，系统错误！");
        }

        return jsonResult;
    }

    /**
     * 获取所有活动信息列表
     */
    @RequestMapping(value = "/selectLists" ,method = RequestMethod.GET)
    public JsonResult selectActivityLists() {
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        try {
            jsonResult = activityService.selectLists();
        } catch (Exception e) {
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + "，系统错误！");
        }

        return jsonResult;
    }

    /**
     * 获取某个活动
     */
    @RequestMapping(value = "/selectInfo",method = RequestMethod.GET)
    public JsonResult selectActivity(String uuId) {
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        if (null == uuId || "".equals(uuId.trim())){
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + "，活动ID不能为空！");
            return jsonResult;
        }
        try {
            jsonResult = activityService.selectInfo(uuId);
        }catch (Exception e){
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + "，系统错误！");
        }
        return jsonResult;
    }
}
