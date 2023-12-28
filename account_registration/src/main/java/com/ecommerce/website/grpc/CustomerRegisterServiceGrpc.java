package com.ecommerce.website.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: customer.proto")
public final class CustomerRegisterServiceGrpc {

  private CustomerRegisterServiceGrpc() {}

  public static final String SERVICE_NAME = "CustomerRegisterService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ecommerce.website.grpc.Customer.CustomerRequest,
      com.ecommerce.website.grpc.Customer.CustomerRegisterResponse> getFetchCustomersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "fetchCustomers",
      requestType = com.ecommerce.website.grpc.Customer.CustomerRequest.class,
      responseType = com.ecommerce.website.grpc.Customer.CustomerRegisterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ecommerce.website.grpc.Customer.CustomerRequest,
      com.ecommerce.website.grpc.Customer.CustomerRegisterResponse> getFetchCustomersMethod() {
    io.grpc.MethodDescriptor<com.ecommerce.website.grpc.Customer.CustomerRequest, com.ecommerce.website.grpc.Customer.CustomerRegisterResponse> getFetchCustomersMethod;
    if ((getFetchCustomersMethod = CustomerRegisterServiceGrpc.getFetchCustomersMethod) == null) {
      synchronized (CustomerRegisterServiceGrpc.class) {
        if ((getFetchCustomersMethod = CustomerRegisterServiceGrpc.getFetchCustomersMethod) == null) {
          CustomerRegisterServiceGrpc.getFetchCustomersMethod = getFetchCustomersMethod = 
              io.grpc.MethodDescriptor.<com.ecommerce.website.grpc.Customer.CustomerRequest, com.ecommerce.website.grpc.Customer.CustomerRegisterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CustomerRegisterService", "fetchCustomers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ecommerce.website.grpc.Customer.CustomerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ecommerce.website.grpc.Customer.CustomerRegisterResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CustomerRegisterServiceMethodDescriptorSupplier("fetchCustomers"))
                  .build();
          }
        }
     }
     return getFetchCustomersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CustomerRegisterServiceStub newStub(io.grpc.Channel channel) {
    return new CustomerRegisterServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CustomerRegisterServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CustomerRegisterServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CustomerRegisterServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CustomerRegisterServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CustomerRegisterServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void fetchCustomers(com.ecommerce.website.grpc.Customer.CustomerRequest request,
        io.grpc.stub.StreamObserver<com.ecommerce.website.grpc.Customer.CustomerRegisterResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFetchCustomersMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFetchCustomersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ecommerce.website.grpc.Customer.CustomerRequest,
                com.ecommerce.website.grpc.Customer.CustomerRegisterResponse>(
                  this, METHODID_FETCH_CUSTOMERS)))
          .build();
    }
  }

  /**
   */
  public static final class CustomerRegisterServiceStub extends io.grpc.stub.AbstractStub<CustomerRegisterServiceStub> {
    private CustomerRegisterServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CustomerRegisterServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CustomerRegisterServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CustomerRegisterServiceStub(channel, callOptions);
    }

    /**
     */
    public void fetchCustomers(com.ecommerce.website.grpc.Customer.CustomerRequest request,
        io.grpc.stub.StreamObserver<com.ecommerce.website.grpc.Customer.CustomerRegisterResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFetchCustomersMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CustomerRegisterServiceBlockingStub extends io.grpc.stub.AbstractStub<CustomerRegisterServiceBlockingStub> {
    private CustomerRegisterServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CustomerRegisterServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CustomerRegisterServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CustomerRegisterServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ecommerce.website.grpc.Customer.CustomerRegisterResponse fetchCustomers(com.ecommerce.website.grpc.Customer.CustomerRequest request) {
      return blockingUnaryCall(
          getChannel(), getFetchCustomersMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CustomerRegisterServiceFutureStub extends io.grpc.stub.AbstractStub<CustomerRegisterServiceFutureStub> {
    private CustomerRegisterServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CustomerRegisterServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CustomerRegisterServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CustomerRegisterServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ecommerce.website.grpc.Customer.CustomerRegisterResponse> fetchCustomers(
        com.ecommerce.website.grpc.Customer.CustomerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getFetchCustomersMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FETCH_CUSTOMERS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CustomerRegisterServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CustomerRegisterServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FETCH_CUSTOMERS:
          serviceImpl.fetchCustomers((com.ecommerce.website.grpc.Customer.CustomerRequest) request,
              (io.grpc.stub.StreamObserver<com.ecommerce.website.grpc.Customer.CustomerRegisterResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CustomerRegisterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CustomerRegisterServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ecommerce.website.grpc.Customer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CustomerRegisterService");
    }
  }

  private static final class CustomerRegisterServiceFileDescriptorSupplier
      extends CustomerRegisterServiceBaseDescriptorSupplier {
    CustomerRegisterServiceFileDescriptorSupplier() {}
  }

  private static final class CustomerRegisterServiceMethodDescriptorSupplier
      extends CustomerRegisterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CustomerRegisterServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CustomerRegisterServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CustomerRegisterServiceFileDescriptorSupplier())
              .addMethod(getFetchCustomersMethod())
              .build();
        }
      }
    }
    return result;
  }
}
