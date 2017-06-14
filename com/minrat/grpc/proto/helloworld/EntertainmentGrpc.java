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
 * <pre>
 *The Entertainment service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.2.0)",
    comments = "Source: helloworld.proto")
public final class EntertainmentGrpc {

  private EntertainmentGrpc() {}

  public static final String SERVICE_NAME = "com.bocloud.grpc.proto.helloworld.Entertainment";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.minrat.grpc.proto.helloworld.GameRequest,
      com.minrat.grpc.proto.helloworld.GameReply> METHOD_GAME =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.bocloud.grpc.proto.helloworld.Entertainment", "Game"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.minrat.grpc.proto.helloworld.GameRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.minrat.grpc.proto.helloworld.GameReply.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EntertainmentStub newStub(io.grpc.Channel channel) {
    return new EntertainmentStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EntertainmentBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EntertainmentBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static EntertainmentFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EntertainmentFutureStub(channel);
  }

  /**
   * <pre>
   *The Entertainment service definition.
   * </pre>
   */
  public static abstract class EntertainmentImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void game(com.minrat.grpc.proto.helloworld.GameRequest request,
        io.grpc.stub.StreamObserver<com.minrat.grpc.proto.helloworld.GameReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GAME, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GAME,
            asyncUnaryCall(
              new MethodHandlers<
                com.minrat.grpc.proto.helloworld.GameRequest,
                com.minrat.grpc.proto.helloworld.GameReply>(
                  this, METHODID_GAME)))
          .build();
    }
  }

  /**
   * <pre>
   *The Entertainment service definition.
   * </pre>
   */
  public static final class EntertainmentStub extends io.grpc.stub.AbstractStub<EntertainmentStub> {
    private EntertainmentStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EntertainmentStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EntertainmentStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EntertainmentStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void game(com.minrat.grpc.proto.helloworld.GameRequest request,
        io.grpc.stub.StreamObserver<com.minrat.grpc.proto.helloworld.GameReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GAME, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *The Entertainment service definition.
   * </pre>
   */
  public static final class EntertainmentBlockingStub extends io.grpc.stub.AbstractStub<EntertainmentBlockingStub> {
    private EntertainmentBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EntertainmentBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EntertainmentBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EntertainmentBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.minrat.grpc.proto.helloworld.GameReply game(com.minrat.grpc.proto.helloworld.GameRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GAME, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *The Entertainment service definition.
   * </pre>
   */
  public static final class EntertainmentFutureStub extends io.grpc.stub.AbstractStub<EntertainmentFutureStub> {
    private EntertainmentFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EntertainmentFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EntertainmentFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EntertainmentFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.minrat.grpc.proto.helloworld.GameReply> game(
        com.minrat.grpc.proto.helloworld.GameRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GAME, getCallOptions()), request);
    }
  }

  private static final int METHODID_GAME = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EntertainmentImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EntertainmentImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GAME:
          serviceImpl.game((com.minrat.grpc.proto.helloworld.GameRequest) request,
              (io.grpc.stub.StreamObserver<com.minrat.grpc.proto.helloworld.GameReply>) responseObserver);
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

  private static final class EntertainmentDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.minrat.grpc.proto.helloworld.HelloWorldProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EntertainmentGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EntertainmentDescriptorSupplier())
              .addMethod(METHOD_GAME)
              .build();
        }
      }
    }
    return result;
  }
}
