## 一、学习目标

- 分析spring,springboot的关键源码，理解核心的设计实现
- 从常用注解出发分析spring开发的基本原理

## 二、相关参考

- 《spring的技术内幕》 学习spring的整体核心技术
- spring,springboot,cloud的关键面经及教学视频（[诸葛spring视频]()、[]()），用来检测，并明确学习的核心
- 冰河的注解开发指南，用来从注解的角度出发分析

## 三、核心分析

### java的前置核心基础知识
1. Java的注解理解【简化配置】
2. Java的反射机制，获取类信息、生成对象--对象的管理【保证单例，资源的利用率】

### spring的整体框架体系
- core:核心，公用
---
- beans:容器管理(beanFactory,)
- context:上下文，对Bean的拓展，增强
---
- aop
---
- web

### spring的关键技术点分析
1. IOC
2. AOP
3. MVC

### springboot的关键技术点分析

1. 自动装配原理
2. starter的理解

### springcloud的组件分析


## 四、注意事项

- 抓大放小，以核心以及和项目相关的知识点出发（GCRoots）去学习，拧主线！！
- 学习过程，注意画图，分析逻辑线，同时注意设计思想、设计模式，原理
- 背景 + 原理 + 应用 【从问题出发理解背景，调试代码并结合设计理念理解原理，调研总结经典实战应用，促进实战】




