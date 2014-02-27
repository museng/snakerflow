/* Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.snaker.engine;

import java.util.List;

import org.snaker.engine.access.Page;
import org.snaker.engine.access.QueryFilter;
import org.snaker.engine.entity.HistoryOrder;
import org.snaker.engine.entity.HistoryTask;
import org.snaker.engine.entity.Order;
import org.snaker.engine.entity.Task;
import org.snaker.engine.entity.WorkItem;

/**
 * 流程相关的查询服务
 * @author yuqs
 * @version 1.0
 */
public interface IQueryService {
	/**
	 * 根据流程实例ID获取流程实例对象
	 * @param orderId 流程实例id
	 * @return Order 流程实例对象
	 */
	Order getOrder(String orderId);
	/**
	 * 根据流程实例ID获取历史流程实例对象
	 * @param orderId 历史流程实例id
	 * @return HistoryOrder 历史流程实例对象
	 */
	HistoryOrder getHistOrder(String orderId);
	/**
	 * 根据任务ID获取任务对象
	 * @param taskId 任务id
	 * @return Task 任务对象
	 */
	Task getTask(String taskId);
	/**
	 * 根据任务ID获取历史任务对象
	 * @param taskId 历史任务id
	 * @return HistoryTask 历史任务对象
	 */
	HistoryTask getHistTask(String taskId);
	/**
	 * 根据任务ID获取活动任务参与者数组
	 * @param taskId 任务id
	 * @return String[] 参与者id数组
	 */
	String[] getTaskActorsByTaskId(String taskId);
	/**
	 * 根据任务ID获取历史任务参与者数组
	 * @param taskId 历史任务id
	 * @return String[] 历史参与者id数组
	 */
	String[] getHistoryTaskActorsByTaskId(String taskId);
	
	/**
	 * 根据参与者分页查询活动任务
	 * @param filter 查询过滤器
	 * @return List<Task> 活动任务集合
	 */
	List<Task> getActiveTasks(QueryFilter filter);
	
	/**
	 * 根据参与者分页查询活动任务
	 * @param page 分页对象
	 * @param filter 查询过滤器
	 * @return List<Task> 活动任务集合
	 */
	List<Task> getActiveTasks(Page<Task> page, QueryFilter filter);
	
	/**
	 * 根据流程定义ID查询流程实例列表
	 * @param filter 查询过滤器
	 * @return List<Order> 活动实例集合
	 */
	List<Order> getActiveOrders(QueryFilter filter);
	
	/**
	 * 根据流程定义ID查询流程实例列表
	 * @param page 分页对象
	 * @param filter 查询过滤器
	 * @return List<Order> 活动实例集合
	 */
	List<Order> getActiveOrders(Page<Order> page, QueryFilter filter);
	
	/**
	 * 分页查询历史流程实例
	 * @param filter 查询过滤器
	 * @return List<HistoryOrder> 历史实例集合
	 */
	List<HistoryOrder> getHistoryOrders(QueryFilter filter);
	
	/**
	 * 分页查询历史流程实例
	 * @param page 分页对象
	 * @param filter 查询过滤器
	 * @return List<HistoryOrder> 历史实例集合
	 */
	List<HistoryOrder> getHistoryOrders(Page<HistoryOrder> page, QueryFilter filter);
	
	/**
	 * 根据流程实例ID查询所有已完成的任务
	 * @param filter 查询过滤器
	 * @return List<HistoryTask> 历史任务集合
	 */
	List<HistoryTask> getHistoryTasks(QueryFilter filter);
	
	/**
	 * 根据参与者分页查询已完成的历史任务
	 * @param page 分页对象
	 * @param filter 查询过滤器
	 * @return List<HistoryTask> 历史任务集合
	 */
	List<HistoryTask> getHistoryTasks(Page<HistoryTask> page, QueryFilter filter);
	
	/**
	 * 根据给定的分页对象page、流程定义processId、参与者ID列表，查询工作项（包含process、order、task三个实体的字段集合）
	 * @param page 分页对象
	 * @param filter 查询过滤器
	 * @return List<WorkItem> 活动工作项集合
	 */
	List<WorkItem> getWorkItems(Page<WorkItem> page, QueryFilter filter);
	
	/**
	 * 根据流程定义ID、参与者分页查询已完成的历史任务项
	 * @param page 分页对象
	 * @param filter 查询过滤器
	 * @return List<WorkItem> 历史工作项集合
	 */
	List<WorkItem> getHistoryWorkItems(Page<WorkItem> page, QueryFilter filter);
}
