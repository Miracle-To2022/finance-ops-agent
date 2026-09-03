# Finance Ops Agent Requirements v0.1

## 1. 目标用户

需要分析 Java 系统故障的开发人员或值班人员。

## 2. 用户问题

面对线程栈、慢 SQL、Redis 指标、Kafka Lag 或排障文档时，
用户需要快速获得有证据、可验证、不过度断言的诊断建议。

## 3. 输入

- 自然语言问题；
- 一份合成日志、SQL、线程栈或指标样本；
- 可选的系统上下文，例如环境、时间范围、版本。

## 4. 输出 DiagnosisReport

- category：问题类别；
- severity：风险等级；
- summary：结论摘要；
- evidence：引用的证据；
- possibleCauses：可能根因，不把推测写成事实；
- actions：建议动作；
- risks：动作风险；
- verification：验证方法；
- insufficientEvidence：证据是否不足。

## 5. 核心流程

问题输入 → 分类 → 选择白名单工具 → 获取证据 → 检索 Runbook
→ 生成结构化报告 → 校验输出 → 记录调用轨迹。

## 6. 非目标

- 不直接修复生产系统；
- 不连接公司内网；
- 不执行写数据库、删 Key、重启服务等危险操作；
- 不在 v0.1 实现多 Agent、复杂前端或 Kubernetes；
- 不保证替代人工判断。

## 7. 安全边界

- 所有样本完全合成；
- 工具默认只读；
- 文件只能来自项目 `samples/`；
- 模型密钥只通过环境变量注入；
- 无足够证据时必须明确回答证据不足。