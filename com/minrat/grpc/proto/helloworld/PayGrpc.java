package com.minrat.grpc.proto.helloworld;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.2.0)",
    comments = "Source: helloworld.proto")
public final class PayGrpc {

  private PayGrpc() {}

  public static final String SERVICE_NAME = "com.bocloud.grpc.proto.helloworld.Pay";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.minrat.grpc.proto.helloworld.PayRequest,
      com.minrat.grpc.proto.helloworld.PayReply> METHOD_CONSUMER_PAY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.bocloud.grpc.proto.helloworld.Pay", "ConsumerPay"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.minrat.grpc.proto.helloworld.PayRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.minrat.grpc.proto.helloworld.PayReply.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PayStub newStub(io.grpc.Channel channel) {
    return new PayStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PayBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PayBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static PayFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PayFutureStub(channel);
  }

  /**
   */
  public static abstract class PayImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void consumerPay(com.minrat.grpc.proto.helloworld.PayRequest request,
        io.grpc.stub.StreamObserver<com.minrat.grpc.proto.helloworld.PayReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CONSUMER_PAY, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CONSUMER_PAY,
            asyncUnaryCall(
              new MethodHandlers<
                com.minrat.grpc.proto.helloworld.PayRequest,
                com.minrat.grpc.proto.helloworld.PayReply>(
                  this, METHODID_CONSUMER_PAY)))
          .build();
    }
  }

  /**
   */
  public static final class PayStub extends io.grpc.stub.AbstractStub<PayStub> {
    private PayStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PayStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PayStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PayStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void consumerPay(com.minrat.grpc.proto.helloworld.PayRequest request,
        io.grpc.stub.StreamObserver<com.minrat.grpc.proto.helloworld.PayReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CONSUMER_PAY, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PayBlockingStub extends io.grpc.stub.AbstractStub<PayBlockingStub> {
    private PayBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PayBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PayBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PayBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.minrat.grpc.proto.helloworld.PayReply consumerPay(com.minrat.grpc.proto.helloworld.PayRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CONSUMER_PAY, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PayFutureStub extends io.grpc.stub.AbstractStub<PayFutureStub> {
    private PayFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PayFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PayFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PayFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.minrat.grpc.proto.helloworld.PayReply> consumerPay(
        com.minrat.grpc.proto.helloworld.PayRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CONSUMER_PAY, getCallOptions()), request);
    }
  }

  private static final int METHODID_CONSUMER_PAY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PayImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PayImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONSUMER_PAY:
          serviceImpl.consumerPay((com.minrat.grpc.proto.helloworld.PayRequest) request,
              (io.grpc.stub.StreamObserver<com.minrat.grpc.proto.helloworld.PayReply>) responseObserver);
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

  private static final class PayDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.minrat.grpc.proto.helloworld.HelloWorldProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PayGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PayDescriptorSupplier())
              .addMethod(METHOD_CONSUMER_PAY)
              .build();
        }
      }
    }
    return result;
  }
}
