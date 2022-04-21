package com.amei.knowledge.springboot.mongo;

public class 聚合demo {
//    public List<FormTemplate> findByCategoryId(String categoryId, int page, int limit) {
//        MatchOperation matchOperation = Aggregation.match(Criteria.where("category_id").is(categoryId));
//        //添加列
//        AddFieldsOperation.AddFieldsOperationBuilder addIdField =
//                AddFieldsOperation.addField("id").withValueOfExpression("_id");
//        AddFieldsOperation addIdFieldBuild = addIdField.build();
//        //移除列
//        ProjectionOperation projectionOperation = Aggregation.project().andExclude("_class", "_id");
//        //分页
//        SkipOperation skipOperation = Aggregation.skip((page - 1) * limit);
//        LimitOperation limitOperation = Aggregation.limit(limit);
//        List<AggregationOperation> aggregationOperations = new ArrayList<>();
//        //追加查询配置
//        aggregationOperations.add(matchOperation);
//        aggregationOperations.add(addIdFieldBuild);
//        aggregationOperations.add(projectionOperation);
//        aggregationOperations.add(skipOperation);
//        aggregationOperations.add(limitOperation);
//        Aggregation aggregation = Aggregation.newAggregation(aggregationOperations);
//        AggregationResults<FormTemplate> aggregateResult =
//                mongoTemplate.aggregate(aggregation, collectionName, FormTemplate.class);
//        return aggregateResult.getMappedResults();
//    }
}
